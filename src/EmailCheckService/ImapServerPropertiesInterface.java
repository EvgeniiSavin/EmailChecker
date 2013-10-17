/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import java.util.Properties;

/**
 *
 * @author user102
 */
public interface ImapServerPropertiesInterface {
    
    public void setImapServerName(String imapServerName);
    public void setImapServerPort(String imapServerPort);
    public void useSSLforServer(String useSSLforServer);
    public String getImapServerName();
    public String getImapServerPort();
    public String getStatusSSLforServer();
    public Properties getProperties();
    
}
