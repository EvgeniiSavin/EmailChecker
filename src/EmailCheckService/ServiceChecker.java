/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import IMAP.ComSunMailImapProvider;
import IMAP.ImapStoreFactory;
import IMAP.ImapStoreOperator;
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
public class ServiceChecker implements ArrayOfAccountPropertiesListenerInterface {

    private ArrayList connectedImapStoreArray = new ArrayList();
    
    ServiceChecker() {
        
    }
    
    @Override
    public void newAddedAccountProperties(AccountProperties accountProperties) {
        
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        
        Store imapStore = 
                        new ImapStoreFactory().createImapStore( accountProperties,
                                                                imapProvider);
        connectedImapStoreArray.add(imapStore);
        
        checkEmailEvery10Sec(imapStore);
    }
    
    private void checkEmailEvery10Sec(Store imapStore) {
        ImapStoreOperator imapChecker = new ImapStoreOperator(imapStore);
        System.out.println("You have a unread message: " + imapChecker.getCountNotReadMessage());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServiceChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkEmailEvery10Sec(imapStore);
        
    }
    
}
