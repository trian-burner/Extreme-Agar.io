import java.net.*;
import java.io.*;
import java.awt.Color;

public class ServerClient {
    String address = "localhost";
    Socket client;
    
    public ServerClient() {
        try {
            System.out.println("Attempting conection to " + address + " on port 2050");
            client = new Socket(address, 2050);
            System.out.println("Connection established");
            
        } catch (ConnectException e) {
            System.out.println("Connection unsuccessful");
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public CellPackage update(CellPackage s) {
        CellPackage r = null;
        try {
            OutputStream outToServer = client.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outToServer);
            oos.writeObject(s);
            //System.out.println("sent");
            
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            r = (CellPackage)in.readObject(); 
            //System.out.println("recieved");
            System.out.println(r);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {}
        return r;
    }
    
    public void stopIt() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}