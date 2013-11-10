/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Properties.AccountProperties;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author horch
 */
public class ReadXMLFromFile {
    
    public AccountProperties getAccountFromXMLFile() {
        AccountProperties accontProp = new AccountProperties();
        
        SAXBuilder builder = new SAXBuilder();
        Document anotherDocument = null;
        
        try {
            anotherDocument =
                                builder.build(new File("properties"));
        } catch (JDOMException ex) {
            Logger.getLogger(ReadXMLFromFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadXMLFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        Element rootElement = anotherDocument.getRootElement();
        Element accountElement = rootElement.getChild("account");
        
       
        accontProp.setUserLogin(accountElement.getChildText("userLogin"));
        accontProp.setUserPassword(accountElement.getChildText("userPassword"));
        accontProp.setServerHost(accountElement.getChildText("serverHost"));
        accontProp.setServerPort(accountElement.getChildText("serverPort"));
        accontProp.setServerProtocol(accountElement.getChildText("serverProtocol"));
        accontProp.setServerSSLStatus(accountElement.getChildText("serverSSLStatus"));
        
        return accontProp;
    }
    
}
