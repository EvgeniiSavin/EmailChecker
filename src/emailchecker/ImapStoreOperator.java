/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    ImapStoreOperator(Store imapStore) {
        this.imapStore = imapStore;
    }
    
    public ArrayList<Folder> getListFolders(ImapUserPermission imapUserPermission) {
        
        ArrayList<Folder> listFolders = null;
        //Connect to Imap Server
        try {
            
            imapStore.connect(imapUserPermission.getUsername(), imapUserPermission.getPassword());
            listFolders = new ArrayList<Folder>(Arrays.asList(imapStore.getDefaultFolder().list()));

        } catch (MessagingException ex) {
            Logger.getLogger(ImapStoreOperator.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return listFolders;
    }
    
    
}
