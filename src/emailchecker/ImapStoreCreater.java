/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import emailchecker.UserPermissions;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.NoSuchProviderException;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author user102
 */
public class ImapStoreCreater {
    private Properties ImapServerProperties;
    private Provider imapProvider;
    private UserPermissions userPermissions;
    
    ImapStoreCreater(  Properties ImapServerProperties,
                        Provider imapProvider,
                        UserPermissions userPermissions) {
        
        this.ImapServerProperties = ImapServerProperties;
        this.imapProvider = imapProvider;
        this.userPermissions = userPermissions;
    }
    
    public Store createImapStore() {
        
        Session imapSession = Session.getInstance(ImapServerProperties);
        Store imapStore = null;
        try {
            imapStore = imapSession.getStore(imapProvider);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ImapStoreCreater.class.getName()).log(Level.SEVERE, "Imap Provider is not correct!", ex);
        }
        
        return imapStore;
    }
    
}
