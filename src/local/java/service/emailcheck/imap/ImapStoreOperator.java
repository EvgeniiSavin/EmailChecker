/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.imap;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

/**
 *
 * @author user102
 */
public class ImapStoreOperator {
    
    Store imapStore;
    
    public ImapStoreOperator(Store imapStore) {
        this.imapStore = imapStore;
    }

    public boolean checkNewMessage() {
        boolean result = false;
        try {
            Folder[] imapFolders = imapStore.getDefaultFolder().list();
            // Check new message
            for(Folder imapFolder:imapFolders) {
                if(imapFolder.hasNewMessages()) result = true;
            }
            
        } catch (MessagingException ex) {
            Logger.getLogger(ImapStoreOperator.class.getName()).log(Level.SEVERE, "Can not get DefaultFolder from ImapStore", ex);
        }
        
        return result;
    }
    
    public int getSumUnreadMessage() {
        int countNewMessage = 0;
        try {
            Folder[] imapFolders = imapStore.getDefaultFolder().list();
            for(Folder imapFolder:imapFolders) {
                countNewMessage = countNewMessage + imapFolder.getUnreadMessageCount();
            }
        } catch (MessagingException ex) {
            Logger.getLogger(ImapStoreOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return countNewMessage;
    }
    
}
