/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMAP;

import EmailCheckService.UserPermission;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author user102
 */
public class ImapStoreFactory {
       
    public ImapStoreFactory() {
        
    }
    
    public Store createImapStore(   Properties imapServerProperties,
                                    Provider imapProvider,
                                    UserPermission userPermissions) {
        
        Session imapSession = Session.getInstance(imapServerProperties);
        Store imapStore = null;
        
        try {
            imapStore = imapSession.getStore(imapProvider);
            // Store connect to Imap Server with User permission
            imapStore.connect(  userPermissions.getUsername(),
                                userPermissions.getPassword());
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ImapStoreFactory.class.getName()).log(Level.SEVERE, "Imap Provider is not correct!", ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ImapStoreFactory.class.getName()).log(Level.SEVERE, "Store can't to connect with User Permissions", ex);
        }
        
        return imapStore;
    }
    
}
