/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import java.util.ArrayList;

/**
 *
 * @author user102
 */
public class StaticArrayProfileContainers {
    
    private static ArrayList<AccountSettings> staticProfileContainer =
            new ArrayList<AccountSettings>();
    
    StaticArrayProfileContainers() {
        
    }
    
    public static void addProfileContainer(AccountSettings objectProfileContainer) {
        staticProfileContainer.add(objectProfileContainer);
    }
    
    public static AccountSettings getProfileContainer(int positionProfileContainer) {
        return staticProfileContainer.get(positionProfileContainer);
    }
    
    public static boolean isEmpty() {
        return staticProfileContainer.isEmpty();
    }

}
