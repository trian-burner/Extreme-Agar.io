import java.net.*;
import java.io.*;

/**
 * The network side of the Server world mode. This Class handles all LAN communications between this Server and the respective Client. As of now, the server is creating a new socket and waiting for a connection.
 * After a connection acception has occured, the Server sends the Client the WorldPackage.
 * Aftere this, the update() method is used to constantly send CellPackages of this Player's Cell and recieve the other Player's CellPackages
 */
public class Server extends Thread {
    private static ServerSocket serverSocket;
    Socket server;
    WorldPackage wp;
   
    /**
     * Creates a new Server, opens a socket, and waits for a connection
     * 
     * @param wp The filled WorldPackage that the Server will use to send to the client when a connection has been established
     */
    public Server(WorldPackage wp) {
        this.wp = wp;
        
        try {
            serverSocket = new ServerSocket(2050);
            server = serverSocket.accept();
            
            OutputStream outToClient = server.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToClient);
            oos.writeObject(wp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a new CellPackage and recieves the other Player's CellPackage whenever called
     * 
     * @param s The CellPackage that will be sent over the socket to the Client
     * 
     * @return Returns the CellPackage the server has recieved from the Client
     */
    public CellPackage update(CellPackage s) {
        CellPackage r = null;
        
        try {
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());
            r = (CellPackage)in.readObject(); 
            
            OutputStream outToClient = server.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToClient);
            oos.writeObject(s);
        }catch(SocketTimeoutException e) {
            System.out.println("Connection timed out!");
        }catch(IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e) {}
        return r;
    }
    
    /**
     * Stops all server processes and closes the currently open sockets when called
     */
    public void stopIt() {
        try {
            serverSocket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}