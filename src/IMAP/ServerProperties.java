/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IMAP;

import java.util.Properties;

/**
 *
 * @author horch
 */
public class ServerProperties {
    
    Properties serverProperties;
    
    public ServerProperties() {
        serverProperties = new Properties();
    }
    
    public void setHost(String host) {
        this.serverProperties.put("mail.imap.host", host);
    }
    
    public void setPort(String port) {
        this.serverProperties.put("mail.imap.port", port);
    }
    
    public void enableSSL(String enableSSL) {
        this.serverProperties.put("mail.imap.ssl.enable", enableSSL);
    }
    
    /**
     * Set "imap"
     * @param host 
     */
    public void setTransportProtocol(String transportProtocol) {
        this.serverProperties.put("mail.transport.protocol", transportProtocol);
    }
    
    public Properties getAllProperties() {
        return this.serverProperties;
    }
}
