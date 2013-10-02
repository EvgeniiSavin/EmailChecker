/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

/**
 *
 * @author user102
 */
public class ImapUserPermission implements UserPermissions {
    
    private String username = "evg.sav2013@yandex.ru";
    private String password = "zohbei4C";
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
