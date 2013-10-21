/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import java.util.ArrayList;

/**
 *
 * @author user102
 */
public class ArrayOfAccountsProperties {
    
    private static ArrayList<AccountProperties> arrayAccountProperties =
            new ArrayList<AccountProperties>();
    
    private static ArrayList<ArrayOfAccountPropertiesListenerInterface> listeners =
            new ArrayList<ArrayOfAccountPropertiesListenerInterface>();
    
    private static AccountProperties accountProperty;
    
    private static int globalArrayPosition = 0;
    
    ArrayOfAccountsProperties() {
        
    }
    
    public static void addAccountProperties(AccountProperties objectProfileContainer) {
        arrayAccountProperties.add(objectProfileContainer);
        sendInfoToListeners();
    }
    
    public static AccountProperties getAccountProperties(int positionProfileContainer) {
        return arrayAccountProperties.get(positionProfileContainer);
    }
    
    public static AccountProperties popAccountProperty() {
        accountProperty = arrayAccountProperties.get(globalArrayPosition);
        
        if(arrayAccountProperties.size() == ++globalArrayPosition) globalArrayPosition = 0;
            
        return accountProperty;
    }
    
    public static boolean isEmpty() {
        return arrayAccountProperties.isEmpty();
    }
    
    public static void addListener(ArrayOfAccountPropertiesListenerInterface objectListener) {
        listeners.add(objectListener);
    }
    
    private static void sendInfoToListeners() {
    
        for(ArrayOfAccountPropertiesListenerInterface listener:listeners) {
            listener.newAccountProperties();
        }
 
    }
    

}
