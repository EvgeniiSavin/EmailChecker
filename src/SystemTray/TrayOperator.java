/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemTray;

/**
 *
 * @author user102
 */
public class TrayOperator {
    
    SystemTrayApplication trayApplication;
    
    public TrayOperator(SystemTrayApplication trayApplication) {
        this.trayApplication = trayApplication;
    }
    
    public void sendInfoMessage(String message) {
        System.out.println(message);    
    }
    
}
