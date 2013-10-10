/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.util.Properties;

/**
 *
 * @author horch
 */
public class YandexImapServerProperties {

    public final String SERVER_NAME = "imap.yandex.ru";
    public final String SERVER_PORT = "993";
    private final String SERVER_SSL_ENABLE = "true";
    private final String SERVER_TRANSPORT = "imap";
    
    public Properties getProperties() {
        Properties propertiesOfImapServer = new Properties();
        
        propertiesOfImapServer.put("mail.imap.ssl.enable", SERVER_SSL_ENABLE);
        propertiesOfImapServer.put("mail.imap.host", SERVER_NAME);
        propertiesOfImapServer.put("mail.imap.port", SERVER_PORT);
        propertiesOfImapServer.put("mail.transport.protocol", SERVER_TRANSPORT);
        
        return propertiesOfImapServer;
    }
    
}
