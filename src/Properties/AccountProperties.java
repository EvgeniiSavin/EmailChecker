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

    private String accountName;
    private String login;
    private String password;
    private String imapServerHost;
    private String imapServerPort;
    private boolean imapSSLStatus;
    
    public AccountProperties() {
        this.accountName = null;
        this.login = null;
        this.password = null;
        this.imapServerHost = null;
        this.imapServerPort = null;
        this.imapSSLStatus = false;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setImapServerHost(String imapServerHost) {
        this.imapServerHost = imapServerHost;
    }
    
    public void setImapServerPort(String imapServerPort) {
        this.imapServerPort = imapServerPort;
    }
    
    public void setImapSSLStatus(boolean imapSSLStatus) {
        this.imapSSLStatus = imapSSLStatus;
    }
    
    public String getAccountName() {
        return this.accountName;
    }
    
    public String getLogin() {
        return this.login;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getImapServerHost() {
        return this.imapServerHost;
    }
    
    public String getImapServerPort() {
        return this.imapServerPort;
    }
    
    public boolean getImapSSLStatus() {
        return this.imapSSLStatus;
    }
    
}
