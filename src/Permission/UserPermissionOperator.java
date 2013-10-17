/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Permission;

import SystemTray.ConfigureUserPermission;

/**
 *
 * @author horch
 */
public class UserPermissionOperator  {
    
    UserPermission user = new UserPermission();
    ConfigureUserPermission window;
    
    public UserPermissionOperator() {
        
    }
    
    public UserPermission getUserPermission() {
        
        if( !isHavePermission() ) {
            window = new ConfigureUserPermission();
            window.setVisible(true);
        }
        
        return user;
    }
    
    private boolean isHavePermission() {
        return false;
    }
    
}
