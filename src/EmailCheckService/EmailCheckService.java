/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import XML.ComSunMailImapProvider;
import Permission.UserPermission;
import Permission.UserPermissionOperator;
import XML.YandexImapServerProperties;
import Permission.ConfigureUserPermission;
import SystemTray.SystemTrayApplication;
import java.awt.AWTException;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Provider;

/**
 *
 * @author horch
 */
public class EmailCheckService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, AWTException {
        // Start ClientTray
        SystemTrayApplication trayApplication = new SystemTrayApplication();
        //TrayOperator trayOperator = new TrayOperator(trayApplication);
        
        
        
        Properties serverProperties = new YandexImapServerProperties().getProperties();
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        
        UserPermission userPermission = new UserPermissionOperator().getUserPermission();
        
        System.out.println(userPermission.getUsername() + " " + userPermission.getPassword());
        
        //Properties userPermission = new XmlUserPermission().getUserProperties();
        
        /*        
        Store imapStore = 
                new ImapStoreFactory().createImapStore( serverProperties,
                                                        imapProvider,
                                                        userPermission );
        
        ImapStoreOperator storeOperator = new ImapStoreOperator(imapStore);
        
        if(storeOperator.checkNewMessage()) 
            trayOperator.sendInfoMessage("New Message!");
        */
        
    }

}
