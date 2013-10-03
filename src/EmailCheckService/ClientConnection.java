/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author horch
 */
public class ClientConnection {
    
    static ServerSocket serverSocket;
    static Socket clientConnection;
    
    ClientConnection() {
        try {
            serverSocket = new ServerSocket(9999);
            clientConnection = serverSocket.accept();
        } catch (IOException ex) {
            Logger.getLogger(TrayClientInformator.class.getName()).log(Level.SEVERE, "Do not bind socket to 9999 port", ex);
        }
    }
    
    static void sendLineToClientConnection(String line) {
        PrintWriter outputClientStream = null;
        
        try {
            outputClientStream = new PrintWriter(clientConnection.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, "Can not get OutputStream for clientSocket", ex);
        }
        
        outputClientStream.write(line);
        outputClientStream.close();
        
    }    
}
