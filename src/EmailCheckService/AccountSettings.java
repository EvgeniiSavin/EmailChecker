/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

/**
 *
 * @author user102
 */
public class AccountSettings {
    
    private String accountName;                             // Simple user-frendly name for account
    private String accountLogin;                            // For example: "user@gmail.com"
    private String accountPassword;                         // Password for login
    private String accountServerName;                       // For example: "imap.gmail.com"
    private String accountServerPort;                       // For example: "993" or "145"
    private String accountUseSSLConnection;                 // "true" or "false"
    private String accountServerTransportProtocol = "imap"; // Type for server
    
    public AccountSettings() {
        
    }
    /**
     * Simple name for account. This name see a user.
     * @param String Name
     */
    public void setName(String name) {
        this.accountName = name;
    }
    
    /**
     * Login use for authentication on imap server.
     * @param String login 
     */
    public void setLogin(String login) {
        this.accountLogin = login;
    }
    
    /**
     * Password use for authentication on imap server
     * @param String password 
     */
    public void setPassword(String password) {
        this.accountPassword = password;
    }
    
    /**
     * ServerName is imap server domain name.
     * For example: "imap.gmail.com"
     * @param String serverName 
     */
    public void setServerName(String serverName) {
        this.accountServerName = serverName;
    }
    
    /**
     * Port user for connection to imap server.
     * For example: "993" or "145"
     * @param String port 
     */
    public void setServerPort(String port) {
        this.accountServerPort = port;
    }
    
    /**
     * Use or not SSL connection for imap server.
     * "true" - enable ssl connection
     * "false" - disable ssl connection
     * @param String useSSLConnection 
     */
    public void setUseSSLConnection(String useSSLConnection) {
        this.accountUseSSLConnection = useSSLConnection;
    }
    
    
}
