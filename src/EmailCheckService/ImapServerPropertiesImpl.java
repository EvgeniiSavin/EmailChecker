/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import java.util.Properties;

/**
 * This class use for contain properties for ImapServer 
 * @author user102
 */
public class ImapServerPropertiesImpl implements ImapServerPropertiesInterface {

    private String imapServerName;
    private String imapServerPort;
    private String useSSLforServer;
    private final String serverTransportProtocol = "imap";
    
    public ImapServerPropertiesImpl() {
        
    }

    /**
     * Method configure FQDN for imap server.
     * For example "imap.google.com" or "imap.yandex.ru"
     * @param String imapServerName 
     */
    @Override
    public void setImapServerName(String imapServerName) {
        this.imapServerName = imapServerName;
    }

    /**
     * The method configure port for imap server.
     * For Example: "993" or "143"
     * Default: "993"
     * @param String imapServerPort 
     */
    @Override
    public void setImapServerPort(String imapServerPort) {
        this.imapServerPort = imapServerPort;
    }
    
    /**
     * The method enable or disable use ssl connection for imap server.
     * For enable ssl: true (default)
     * For disable ssl: false
     * @param useSSLforServer 
     */
    @Override
    public void useSSLforServer(String useSSLforServer) {
        this.useSSLforServer = useSSLforServer;
    }

    /**
     * The method return server configure by Properties object, which can be use in javamail lib
     * @return Properties object
     */
    @Override
    public Properties getProperties() {
        Properties propertiesOfImapServer = new Properties();
        
        propertiesOfImapServer.put("mail.imap.ssl.enable", useSSLforServer);
        propertiesOfImapServer.put("mail.imap.host", imapServerName);
        propertiesOfImapServer.put("mail.imap.port", imapServerPort);
        propertiesOfImapServer.put("mail.transport.protocol", serverTransportProtocol);
        
        return propertiesOfImapServer;
    }

    @Override
    public String getImapServerName() {
        return this.imapServerName;
    }

    @Override
    public String getImapServerPort() {
        return this.imapServerPort;
    }

    @Override
    public String getStatusSSLforServer() {
        return this.useSSLforServer;
    }
    
}
