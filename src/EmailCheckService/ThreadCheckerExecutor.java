/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author horch
 */
public class ThreadCheckerExecutor {
    
    //private static ArrayList<Thread> arrayOfCheckers = new ArrayList<Thread>();
    private static ExecutorService arrayOfRunningThreadCheckers = Executors.newCachedThreadPool();
    
    public static void addChecker(Thread checker) {
        arrayOfRunningThreadCheckers.submit(checker);
        //arrayOfCheckers.add(checker);
        //checker.start();
    }
    
}
