/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Permission;

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
        //ListenerExecutor listenerExecutor = new ListenerExecutor();
        
        if( !isHavePermission() ) {
            window = new ConfigureUserPermission();
            window.setVisible(true);
            //window.show();
            //window.ButtonOk.addActionListener(listenerExecutor);
            
        }
        
        return user;
    }
    
    private boolean isHavePermission() {
        return false;
    }
    
}
