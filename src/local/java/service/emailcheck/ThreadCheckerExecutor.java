/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import local.java.service.emailcheck.accounts.Account;
import local.java.service.emailcheck.accounts.operator.AccountOperator;

/**
 *
 * @author horch
 */
public class ThreadCheckerExecutor {
    
    private static ExecutorService arrayOfRunningThreadCheckers = Executors.newCachedThreadPool();
    
    public static void startCheckers() {
        Account account = new AccountOperator().getAccount();
        if( account != null ) {
            createAndRunNewChecker(account);
        }
    }
    
    public static void createAndRunNewChecker(Account account) {
        CheckerFactory emailChecker = new CheckerFactory(account);
        Thread emailCheckThread = new Thread(emailChecker);
        addChecker(emailCheckThread);
    }
    
    
    private static void addChecker(Thread checker) {
        arrayOfRunningThreadCheckers.submit(checker);
    }
    
    
}
