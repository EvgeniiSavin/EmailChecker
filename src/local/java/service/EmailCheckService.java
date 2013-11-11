/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service;

import local.java.service.emailcheck.CheckerFactory;
import local.java.service.emailcheck.ThreadCheckerExecutor;
import local.java.service.emailcheck.tray.SystemTrayApplication;
import local.java.service.emailcheck.accounts.operator.XMLFileReader;
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
        XMLFileReader accountFromXML = new XMLFileReader();
        
        CheckerFactory emailChecker = new CheckerFactory(accountFromXML.getAccountFromXMLFile());
        Thread emailCheckThread = new Thread(emailChecker);
        ThreadCheckerExecutor.addChecker(emailCheckThread);
        
    }

}
