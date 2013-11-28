/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck;

import local.java.service.emailcheck.imap.ComSunMailImapProvider;
import local.java.service.emailcheck.imap.ImapStoreFactory;
import local.java.service.emailcheck.imap.ImapStoreOperator;
import local.java.service.emailcheck.accounts.Account;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Provider;
import javax.mail.Store;
import local.java.service.EmailCheckService;

/**
 *
 * @author horch
 */
public class CheckerFactory implements Runnable {

    private Provider imapProvider;
    private Store imapStore;
    private ImapStoreOperator imapStoreOperator;
    private int countUnreadMessage;
    private int countNewMessage;
    private String infoMessage;
    
    public CheckerFactory(Account account) {
        this.imapProvider = new ComSunMailImapProvider().getProvider();
        this.imapStore = new ImapStoreFactory().createImapStore( account, imapProvider);
        this.imapStoreOperator = new ImapStoreOperator(imapStore);
    }
    
    
    @Override
    public void run() {
        while(true) {
            waitTenSeconds();
            countUnreadMessage = imapStoreOperator.getSumUnreadMessage();
            infoMessage = createStringOfUnreadMessage(countUnreadMessage);
            EmailCheckService.showInfoMessageForUser(infoMessage);
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
