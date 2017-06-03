import java.net.*;
import java.io.*;
import java.awt.Color;

/**
 * The network side of the Client world mode. This Class handles all LAN communications between this Client and the respective Server. As of now, the client is creating a new socket and attempting a connection to the set IP address and port.
 * After a connection has been established, the Server sends this Client the WorldPackage.
 * Aftere this, the update() method is used to constantly send CellPackages of this Player's Cell and recieve the other Player's CellPackages
 */
public class ServerClient {
    String address = "localhost";
    Socket client;
    WorldPackage wp;
    
    /**
     * Creates a new Client, opens a socket, and attempts a connection to a server
     */
    public ServerClient() {
        try {
            client = new Socket(address, 2050);
            
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            wp = (WorldPackage)in.readObject(); 
        } catch (ConnectException e) {
            System.out.println("Connection unsuccessful");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {}
    }
    
    /**
     * Sends a new CellPackage and recieves the other Player's CellPackage whenever called
     * 
     * @param s The CellPackage that will be sent over the socket to the Server
     * 
     * @return Returns the CellPackage the Client has recieved from the Server
     */
    public CellPackage update(CellPackage s) {
        CellPackage r = null;
        
        try {
            OutputStream outToServer = client.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToServer);
            oos.writeObject(s);
            
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            r = (CellPackage)in.readObject(); 
        } catch (SocketException e) {
            stopIt();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {} 
        return r;
    }
    
    /**
     * Stops all Client processes and closes the currently open sockets when called
     */
    public void stopIt() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Used by Agar to initially recieve the world and create a world based off of it
     * 
     * @return The WorldPackage recieved from the Server
     */
    public WorldPackage getWorld() {
        return wp;
    }
}