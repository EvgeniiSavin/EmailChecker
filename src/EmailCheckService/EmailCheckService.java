/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import SystemTray.SystemTrayApplication;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;

/**
 *
 * @author horch
 */
public class EmailCheckService {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, AWTException, InterruptedException {
        // Start ClientTray
        SystemTrayApplication trayApplication = new SystemTrayApplication();
        //TrayOperator trayOperator = new TrayOperator(trayApplication);
        
        ServiceChecker accountListener = new ServiceChecker();
        
        ArrayOfAccountProperties.addListener(accountListener);
        
    }
    
}
