/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import IMAP.ImapStoreFactory;
import IMAP.ImapStoreOperator;
import Store.ComSunMailImapProvider;
import Permission.UserPermission;
import Permission.UserPermissionOperator;
import Store.YandexImapServerProperties;
import SystemTray.SystemTrayApplication;
import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import javax.mail.Provider;
import javax.mail.Store;

/**
 *
 * @author horch
 */
public class EmailCheckService {
    
    public static ArrayList<UserPermission> boxUserPermission = 
                        new ArrayList<UserPermission>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, AWTException, InterruptedException {
        // Start ClientTray
        SystemTrayApplication trayApplication = new SystemTrayApplication();
        //TrayOperator trayOperator = new TrayOperator(trayApplication);
        Timer timer = new Timer();
        
        
        Properties serverProperties = new YandexImapServerProperties().getProperties();
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        
        
        //UserPermission userPermission = new UserPermissionOperator().getUserPermission();
        //System.out.println(userPermission.getUsername() + " " + userPermission.getPassword());
        //Properties userPermission = new XmlUserPermission().getUserProperties();
        while(true) {
            System.out.println(boxUserPermission.isEmpty());
            if(!boxUserPermission.isEmpty()) {
                Store imapStore = 
                        new ImapStoreFactory().createImapStore( serverProperties,
                                                                imapProvider,
                                                                boxUserPermission.get(0));

               ImapStoreOperator storeOperator = new ImapStoreOperator(imapStore);

                if(storeOperator.checkNewMessage()) 
                    System.out.println("New Message!");
                    //trayOperator.sendInfoMessage("New Message!");
                
            }
            TimeUnit.SECONDS.sleep(3);
        }
        
    }
    
}
