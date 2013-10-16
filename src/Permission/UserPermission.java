/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Permission;

/**
 *
 * @author user102
 */
public class UserPermission {
    
    private String nameProfile = "";
    private String username = "";
    private String password = "";
    private String server = "";
    private boolean isHavePermission = false;
    
    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setServer(String server) {
        this.server = server;
    }
    
    public String getNameProfile() {
        return this.nameProfile;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getServer() {
        return this.server;
    }
    
    public void setIsHavePermission(boolean isHavePermission) {
        this.isHavePermission = isHavePermission;
    }
    
    public boolean isHavePermission() {
        return isHavePermission;
    }
    
    
}
