/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.imap;

import local.java.service.emailcheck.accounts.Account;
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
    
    public Store createImapStore(   Account accountProperties,
                                    Provider imapProvider) {
        
        
        Session imapSession = Session.getInstance(getServerProperties(accountProperties));
        Store imapStore = null;
        
        try {
            imapStore = imapSession.getStore(imapProvider);
            // Store connect to Imap Server with User permission
            imapStore.connect(  accountProperties.getUserLogin(),
                                accountProperties.getUserPassword());
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ImapStoreFactory.class.getName()).log(Level.SEVERE, "Imap Provider is not correct!", ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ImapStoreFactory.class.getName()).log(Level.SEVERE, "Store can't to connect with User Permissions", ex);
        }
        
        return imapStore;
    }
    
    public Properties getServerProperties(Account accountProperties) {
        Properties serverProp = new Properties();

        serverProp.setProperty("mail.imap.host", accountProperties.getServerHost());
        serverProp.setProperty("mail.imap.port", accountProperties.getServerPort());
        serverProp.setProperty("mail.imap.ssl.enable", accountProperties.getServerSSLStatus());
        serverProp.setProperty("mail.transport.protocol", "imap");

        return serverProp;
    
    }
}
