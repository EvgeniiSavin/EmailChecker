/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newLogic;

import java.util.ArrayList;

/**
 *
 * @author horch
 */
public class ArrayOfCheckers {
    
    private static ArrayList<Thread> arrayOfCheckers = new ArrayList<Thread>();
    
    public static void addChecker(Thread checker) {
        arrayOfCheckers.add(checker);
        checker.start();
    }
    
}
