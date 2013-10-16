/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import IMAP.ImapStoreFactory;
import Store.ComSunMailImapProvider;
import Store.YandexImapServerProperties;
import SystemTray.SystemTrayApplication;
import java.awt.AWTException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Provider;
import javax.mail.Store;

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
        //TrayOperator trayOperator = new TrayOperator(trayApplication);
        
        
        
        Properties serverProperties = new YandexImapServerProperties().getProperties();
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        UsersPermissionOperator userPermOperator = new UsersPermissionOperator();
        
        while(true) {
            //System.out.println(boxUserPermission.isEmpty());
            if(userPermOperator.isHasUserPermission()) {
                Store imapStore = 
                        new ImapStoreFactory().createImapStore( serverProperties,
                                                                imapProvider,
                                                                userPermOperator.getNextUserPermission());

               //ImapStoreOperator storeOperator = new ImapStoreOperator(imapStore);

               Folder[] folders = imapStore.getDefaultFolder().list();
               
               for(Folder folder:folders) {
                   System.out.println(folder.getName() + ": " + folder.getMessageCount());
               }

            }
            TimeUnit.SECONDS.sleep(10);
        }
        
    }
    
}
