/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import DataStoreOfService.ComSunMailImapProvider;
import DataStoreOfService.UserPermissionProperties;
import DataStoreOfService.YandexImapServerProperties;
import TrayClient.ServerConnector;
import TrayClient.Tray;
import java.awt.AWTException;
import java.util.Properties;
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
    public static void main(String[] args) throws MessagingException, AWTException {
        // Start ServerConnector
        
        // Start ClientTray
        new Tray();
        
        Properties serverProperties = new YandexImapServerProperties().getProperties();
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        Properties userPermission = new UserPermissionProperties().getUserProperties();
                
        Store imapStore = 
                new ImapStoreFactory().createImapStore( serverProperties,
                                                        imapProvider,
                                                        userPermission );
        
        ImapStoreOperator storeOperator = new ImapStoreOperator(imapStore);
        TrayClientInformator clientInformator = new TrayClientInformator();
        
        if(storeOperator.checkNewMessage()) 
            clientInformator.sendEventOfNewMessage();
        
        
    }

}
