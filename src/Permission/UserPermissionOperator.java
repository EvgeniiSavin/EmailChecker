/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Permission;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ListenerExecutor listenerExecutor = new ListenerExecutor();
        
        if( !isHavePermission() ) {
            window = new ConfigureUserPermission();
            window.setVisible(true);
            window.show();
            window.ButtonOk.addActionListener(listenerExecutor);
            
        }
        
        return user;
    }
    
    private boolean isHavePermission() {
        return false;
    }
    

    private class ListenerExecutor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            user.setPassword(window.PasswordField.getText());
            user.setUsername(window.UsernameField.getText());
            System.out.println("USER: " + user.getUsername() + " " + user.getPassword());
        
        }
        
    }
}
