/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import IMAP.ComSunMailImapProvider;
import IMAP.ImapStoreFactory;
import IMAP.ImapStoreOperator;
import Properties.AccountProperties;
import Properties.ArrayOfAccountsProperties;
import SystemTray.SystemTrayApplicationOperator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Provider;
import javax.mail.Store;

/**
 *
 * @author horch
 */

public class ServiceChecker {
    
    private SystemTrayApplicationOperator trayOperator;
    private Provider imapProvider;
    private AccountProperties accountProperties;
    private Store imapStore;
    private ImapStoreOperator imapStoreOperator;
    private int countUnreadMessage;
    private int countNewMessage;
    private String infoMessage;
    
    ServiceChecker() {
        
        trayOperator = new SystemTrayApplicationOperator();
        imapProvider = new ComSunMailImapProvider().getProvider();
        checkNewEmail();

    }
    
    private void checkNewEmail() {
        // Check Static Array which contain AccountProperties for a Accounts
        if(!ArrayOfAccountsProperties.isEmpty()) {
            
            accountProperties = ArrayOfAccountsProperties.popAccountProperty();

            imapStore = new ImapStoreFactory().createImapStore( accountProperties, imapProvider);

            imapStoreOperator = new ImapStoreOperator(imapStore);

            countUnreadMessage = imapStoreOperator.getSumUnreadMessage();

            infoMessage = createStringOfUnreadMessage(countUnreadMessage);

            trayOperator.showInfoMessage(infoMessage);
            
        }
        // Check new unread messages every 10 seconds
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

   private String createStringOfUnreadMessage(int countUnreadMessage) {
       return "You have a unread message: " + countUnreadMessage;
   }
   
   
}
