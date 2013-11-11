/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.accounts;

/**
 *
 * @author user102
 */
public class Account {

    private String accountName;
    private String userLogin;
    private String userPassword;
    private String serverHost;
    private String serverPort;
    private String serverProtocol;
    private String serverSSLStatus;
    
    public Account() {
        this.accountName = null;
        this.userLogin = null;
        this.userPassword = null;
        this.serverHost = null;
        this.serverPort = null;
        this.serverSSLStatus = null;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public void setUserLogin(String login) {
        this.userLogin = login;
    }
    
    public void setUserPassword(String password) {
        this.userPassword = password;
    }
    
    public void setServerHost(String imapServerHost) {
        this.serverHost = imapServerHost;
    }
    
    public void setServerPort(String imapServerPort) {
        this.serverPort = imapServerPort;
    }
    
    public void setServerProtocol(String serverProtocol) {
        this.serverProtocol = serverProtocol;
    }
    
    public void setServerSSLStatus(String imapSSLStatus) {
        this.serverSSLStatus = imapSSLStatus;
    }
    
    public String getAccountName() {
        return this.accountName;
    }
    
    public String getUserLogin() {
        return this.userLogin;
    }
    
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public String getServerHost() {
        return this.serverHost;
    }
    
    public String getServerPort() {
        return this.serverPort;
    }
    
    public String getServerProtocol() {
        return this.serverProtocol;
    }
    
    public String getServerSSLStatus() {
        return this.serverSSLStatus;
    }
    
}
