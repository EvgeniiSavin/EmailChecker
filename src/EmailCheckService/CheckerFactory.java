/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import IMAP.ComSunMailImapProvider;
import IMAP.ImapStoreFactory;
import IMAP.ImapStoreOperator;
import Properties.AccountProperties;
import SystemTray.SystemTrayApplicationOperator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Provider;
import javax.mail.Store;

/**
 *
 * @author horch
 */
public class CheckerFactory implements Runnable,CheckerInterface {

    private SystemTrayApplicationOperator trayOperator;
    private Provider imapProvider;
    private Store imapStore;
    private ImapStoreOperator imapStoreOperator;
    private int countUnreadMessage;
    private int countNewMessage;
    private String infoMessage;
    
    public CheckerFactory(AccountProperties accountProperties) {
        this.trayOperator = new SystemTrayApplicationOperator();
        this.imapProvider = new ComSunMailImapProvider().getProvider();
        this.imapStore = new ImapStoreFactory().createImapStore( accountProperties, imapProvider);
        this.imapStoreOperator = new ImapStoreOperator(imapStore);
    }
    
    
    @Override
    public void run() {
        while(true) {
            waitTenSeconds();
            countUnreadMessage = imapStoreOperator.getSumUnreadMessage();
            infoMessage = createStringOfUnreadMessage(countUnreadMessage);
            trayOperator.showInfoMessage(infoMessage);
            Thread.yield();
        }
    }
    
    private void waitTenSeconds() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(CheckerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String createStringOfUnreadMessage(int countUnreadMessage) {
        return "You have a unread message: " + countUnreadMessage;
    }
}
