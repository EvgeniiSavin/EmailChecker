/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoreOfService;

import TrayInformer.ConfigureUserPermission;

/**
 *
 * @author horch
 */
public class UserPermissionOperator {
    
    public UserPermissionOperator() {
        
    }
    
    public UserPermission getUserPermission() {
        
        if( isHavePermission() ) {
            ConfigureUserPermission window = new ConfigureUserPermission();
            window.ButtonOk.setVisible(true);
            window.ButtonOk.show();
        }
        
        return null;
    }
    
    private boolean isHavePermission() {
        return false;
    }
    
}
