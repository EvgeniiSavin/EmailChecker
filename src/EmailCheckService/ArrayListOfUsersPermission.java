/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import Permission.UserPermission;
import java.util.ArrayList;

/**
 *
 * @author user102
 */
public class ArrayListOfUsersPermission {
    
    private static ArrayList<UserPermission> arrayOfUsersPermission = 
                        new ArrayList<UserPermission>();
    
    public void addUserPermission(UserPermission userPerm) {
        arrayOfUsersPermission.add(userPerm);
    }
    
    /**
     * The getNextUserPermission() method return UserPermission object from
     * ArrayList of UserPermission to circle.
     * @return UserPermission
     */
    public UserPermission getNextUserPermission() {
        
        
        return null;
    }
    
}
