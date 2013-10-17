/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import Permission.UserPermission;

/**
 *
 * @author user102
 */
public class ProfileContainer {
    
    private String ProfileName;
    private UserPermission userPermission;
    private ImapServerPropertiesImpl imapServerProperties;
    
    public ProfileContainer() {
        
    }
    
    public void setProfileName(String strProfileName) {
        this.ProfileName = strProfileName;
    }
    
    public void setUserPrermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }
    
    public void setImapServerProperties(ImapServerPropertiesImpl imapServerProperties) {
        this.imapServerProperties = imapServerProperties;
    }
    
    public String getProfileName() {
        return this.ProfileName;
    }
    
    public UserPermission getUserPermission() {
        return this.userPermission;
    }
    
    public ImapServerPropertiesImpl getImapServerProperties() {
        return this.imapServerProperties;
    }
    
}
