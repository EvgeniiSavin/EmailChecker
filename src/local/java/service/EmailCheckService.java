/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service;

import local.java.service.emailcheck.tray.SystemTrayApplication;
import local.java.service.file.operator.PropertiesXMLFileReader;
import java.awt.AWTException;
import javax.mail.MessagingException;
import local.java.service.emailcheck.ThreadCheckerExecutor;

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
        PropertiesXMLFileReader accountFromXML = new PropertiesXMLFileReader();
        
        ThreadCheckerExecutor.startCheckers();
    }

}
