/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrayClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author horch
 */
public class ServerConnector {
    private Socket serverConnection;
    
    ServerConnector() {
        try {
            serverConnection = new Socket("localhost", 9999);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerConnector.class.getName()).log(Level.SEVERE, "Unknown server name", ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerConnector.class.getName()).log(Level.SEVERE, "Can not connect to server", ex);
        }
    }
    
    public String getLineFromServer() {
        InputStreamReader inputStreamReaderFromServer = null;
        try {
            inputStreamReaderFromServer = new InputStreamReader(serverConnection.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerConnector.class.getName()).log(Level.SEVERE, "Can not get InputReaderStream from ServerConnection", ex);
        }
        
        BufferedReader inputServerString;
        inputServerString = new BufferedReader(inputStreamReaderFromServer);
        
        String lineFromServer = null;
        try {
            lineFromServer = inputServerString.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ServerConnector.class.getName()).log(Level.SEVERE, "Can not get line from server", ex);
        }
        
        return lineFromServer;
    }
}
