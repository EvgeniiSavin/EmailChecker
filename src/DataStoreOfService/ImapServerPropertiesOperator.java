/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoreOfService;

import java.util.Properties;

/**
 *
 * @author horch
 */
public class ImapServerPropertiesOperator {
    
    
    public Properties getImapServerProperties() {
        return new YandexImapServerProperties().getProperties();
    }
    
}
