/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service;

import local.java.service.emailcheck.tray.SystemTrayApplication;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.mail.MessagingException;
import local.java.service.emailcheck.CheckerFactory;
import local.java.service.emailcheck.accounts.Account;
import local.java.service.emailcheck.accounts.AccountOperator;

/**
 *
 * @author horch
 */
public class EmailCheckService {
    
    private static SystemTrayApplication trayApplication;
    private static ExecutorService arrayOfRunningThreadCheckers = Executors.newCachedThreadPool();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException, AWTException, InterruptedException {
        
        trayApplication = new SystemTrayApplication();
        
        Account account = getAccount();
        if( account != null ) {
            arrayOfRunningThreadCheckers.submit( createCheckThread(account) );
        }
        
    }
    
    public static void addAccount(Account account) {
    
        new AccountOperator().writeAccountToXML(account);
        arrayOfRunningThreadCheckers.submit(createCheckThread(account));

    }
    
    public static Account getAccount() {
        return new AccountOperator().getAccount();
    }
    
    private static Thread createCheckThread(Account account) {
        return new Thread( new CheckerFactory(account) );
    }
    
    public static void showInfoMessageForUser(String message) {
        trayApplication.showInfoMessage(message);
    }
}
