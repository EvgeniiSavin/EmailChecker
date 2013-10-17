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
public class UsersPermissionOperator {
    
    private static ArrayList<UserPermission> arrayOfUsersPermission = 
                       new ArrayList<UserPermission>();
    
    private static int positionOfArray = 0;
    
    public void addUserPermission(UserPermission userPerm) {
        arrayOfUsersPermission.add(userPerm);
    }
    
    
    public UserPermission getNextUserPermission() {
        UserPermission result = null;
        // Check position
        if(positionOfArray == arrayOfUsersPermission.size()) positionOfArray = 0;
        // Return UserPermission
        if(!arrayOfUsersPermission.isEmpty()) {
            result = arrayOfUsersPermission.get(positionOfArray);
            positionOfArray++;
        }
        return result;
    }
    
    public boolean isHasUserPermission() {
        boolean result = false;
        
        if(!arrayOfUsersPermission.isEmpty()) result = true;
        
        return result;
    }
    
    
}
