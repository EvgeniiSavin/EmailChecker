/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

/**
 *
 * @author horch
 */
public class EmailChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, AWTException {
        
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\horch\\Documents\\NetBeansProjects\\EmailChecker\\src\\emailchecker\\icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "EmailChecker");
        tray.add(trayIcon);
        
        
        
        
        YandexImapServer imapServer = new YandexImapServer();
        ImapProvider imapProvider = new ImapProvider();
        ImapUserPermission userPermission = new ImapUserPermission();
        
        
        ImapStoreCreater storeCreator =
                                new ImapStoreCreater(   imapServer.getProperties(),
                                                        imapProvider.getProvider(),
                                                        userPermission );
        
        Store imapStore = storeCreator.createImapStore();
        
        ImapStoreOperator storeOperator = new ImapStoreOperator(imapStore);
        
        for(Folder folder:storeOperator.getListFolders(userPermission)) {
            System.out.println(folder.getName() + " " + "(" + folder.getMessageCount() + ")");
            
            if(folder.getMessageCount() > 0) {
                System.out.print("        ");
                System.out.println(folder.getNewMessageCount());
            }

        }
        
        
    }
}
