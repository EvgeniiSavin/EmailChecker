/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

/**
 *
 * @author horch
 */
public class TrayClientInformator {
    
    public void sendEventOfNewMessage() {
        ClientConnection.sendLineToClientConnection("New Message!");
        //System.out.println("New Message!");
    }
    
}
