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
public class ArrayOfAccountProperties {
    
    private static ArrayList<AccountProperties> staticProfileContainer =
            new ArrayList<AccountProperties>();
    
    private static ArrayList<ArrayOfAccountPropertiesListenerInterface> objectListeners =
            new ArrayList<ArrayOfAccountPropertiesListenerInterface>();
    
    ArrayOfAccountProperties() {
        
    }
    
    public static void addAccountProperties(AccountProperties objectProfileContainer) {
        staticProfileContainer.add(objectProfileContainer);
        for(ArrayOfAccountPropertiesListenerInterface listener:objectListeners) {
            listener.newAddedAccountProperties(objectProfileContainer);
        }
    }
    
    public static AccountProperties getAccountProperties(int positionProfileContainer) {
        return staticProfileContainer.get(positionProfileContainer);
    }
    
    public static boolean isEmpty() {
        return staticProfileContainer.isEmpty();
    }
    
    public static void addListener(ArrayOfAccountPropertiesListenerInterface objectListener) {
        objectListeners.add(objectListener);
    }
    
    

}
