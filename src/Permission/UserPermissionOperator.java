/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Permission;

/**
 *
 * @author horch
 */
public class UserPermissionOperator {
    
    public UserPermissionOperator() {
        
    }
    
    public UserPermission getUserPermission() {

        if( !isHavePermission() ) {
            ConfigureUserPermission window = new ConfigureUserPermission();
            window.setVisible(true);
            window.show();
            
            
        }
        
        return null;
    }
    
    private boolean isHavePermission() {
        return false;
    }
    
    private void requestPermissionByForm() {
        
    }
    
}
