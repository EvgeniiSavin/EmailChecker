/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import java.util.Properties;

/**
 *
 * @author horch
 */
public class UserProperties {
    
    private Properties userProperties;
    
    public UserProperties() {
        userProperties = new Properties();
    }
    
    public void setLogin(String login) {
        userProperties.setProperty("login", login);
    }
    public void setPassword(String password) {
        userProperties.setProperty("password", password);
    }
    
    public String getLogin() {
        return this.userProperties.getProperty("login");
    }
    
    public String getPassword() {
        return this.userProperties.getProperty("password");
    }
    
    public Properties getAllProperties() {
        return this.userProperties;
    }
    
}
