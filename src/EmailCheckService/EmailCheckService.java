/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import DataStoreOfService.ComSunMailImapProvider;
import DataStoreOfService.YandexImapServerProperties;
import TrayInformer.SystemTrayApplication;
import TrayInformer.TrayOperator;
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
        // Start ClientTray
        SystemTrayApplication trayApplication = new SystemTrayApplication();
        TrayOperator trayOperator = new TrayOperator(trayApplication);
        
        
        
        Properties serverProperties = new YandexImapServerProperties().getProperties();
        Provider imapProvider = new ComSunMailImapProvider().getProvider();
        Properties userPermission = new XmlUserPermission().getUserProperties();
                
        Store imapStore = 
                new ImapStoreFactory().createImapStore( serverProperties,
                                                        imapProvider,
                                                        userPermission );
        
        ImapStoreOperator storeOperator = new ImapStoreOperator(imapStore);
        
        if(storeOperator.checkNewMessage()) 
            trayOperator.sendInfoMessage("New Message!");
        
        
    }

}
