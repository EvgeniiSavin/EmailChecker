/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

/**
 *
 * @author user102
 */
public class AccountProperties {

    private UserProperties userProperties;
    private ServerProperties serverProperties;
    
    public AccountProperties() {
        
    }
    
    public void addUserProperties(UserProperties userProperties) {
        this.userProperties = userProperties;
    }
    
    public void addServerProperties(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }
    
    public UserProperties getUserProperties() {
        return this.userProperties;
    }
    
    public ServerProperties getServerProperties() {
        return this.serverProperties;
    }
}
