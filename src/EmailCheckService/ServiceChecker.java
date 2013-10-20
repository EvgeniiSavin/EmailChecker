/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import IMAP.ComSunMailImapProvider;
import IMAP.ImapStoreFactory;
import IMAP.ImapStoreOperator;
import Properties.AccountProperties;
import Properties.ArrayOfAccountProperties;
import SystemTray.SystemTrayApplicationOperator;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Provider;
import javax.mail.Store;

/**
 *
 * @author horch
 */
//public class ServiceChecker implements ArrayOfAccountPropertiesListenerInterface {
public class ServiceChecker {
    
    ServiceChecker() {
        checkNewEmail();
    }
    
    private void checkNewEmail() {
        
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        
        if(!ArrayOfAccountProperties.isEmpty()) {
            AccountProperties accountProperties = ArrayOfAccountProperties.popAccountProperty();
            
            Store imapStore = new ImapStoreFactory().createImapStore( accountProperties, imapProvider);

            ImapStoreOperator imapChecker = new ImapStoreOperator(imapStore);

            int countUnreadMessage = imapChecker.getCountNotReadMessage();

            SystemTrayApplicationOperator trayOperator = new SystemTrayApplicationOperator();

            String infoMessage = "You have a unread message: " + countUnreadMessage;

            trayOperator.showInfoMessage(infoMessage);
        }
        waitTenSeconds();

        checkNewEmail();
    }
    
    private void waitTenSeconds() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServiceChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
