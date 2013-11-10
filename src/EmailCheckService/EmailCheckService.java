/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import SystemTray.SystemTrayApplication;
import XML.ReadXMLFromFile;
import java.awt.AWTException;
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
        ReadXMLFromFile accountFromXML = new ReadXMLFromFile();
        
        CheckerFactory emailChecker = new CheckerFactory(accountFromXML.getAccountFromXMLFile());
        Thread emailCheckThread = new Thread(emailChecker);
        ThreadCheckerExecutor.addChecker(emailCheckThread);
        
    }

}
