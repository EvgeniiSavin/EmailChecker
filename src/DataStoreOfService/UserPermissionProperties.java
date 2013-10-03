/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoreOfService;

import java.util.Properties;



/**
 *
 * @author user102
 */
public class UserPermissionProperties {
    
    //This properties will need write to XML
    private String username = "evg.sav2013@yandex.ru";
    private String password = "zohbei4C";
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Properties getUserProperties() {
        Properties userProperties = new Properties();
        userProperties.put("username", username);
        userProperties.put("password", password);
        return userProperties;
    }
    
}
