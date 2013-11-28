/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.tray.informator;

/**
 *
 * @author horch
 */
public class SystemTrayApplicationOperator {
    
    public void showInfoMessage(String infoMessage) {
        System.out.println(infoMessage);
        WindowInfoMessage windowInfo = new WindowInfoMessage();
        windowInfo.InformerWindow.setText(infoMessage);
        windowInfo.show();
    }
    
}
