/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.accounts.operator;

import local.java.service.emailcheck.accounts.Account;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.java.service.emailcheck.variables.Variables;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author horch
 */
public class XMLFileReader {
    
    public Account getAccountFromXMLFile() {

        Document xmlDocument = getXMLDocumentFromFile(Variables.ACCOUNT_PROPERTIES);
        return createAccountFromXMLDocument(xmlDocument);

    }
    
    private Account createAccountFromXMLDocument(Document xmlDocument) {
        Account result = new Account();
        Element rootElement = xmlDocument.getRootElement();
        Element accountElement = rootElement.getChild(Variables.ACCOUNT);
        
       
        result.setUserLogin(accountElement.getChildText(Variables.ACCOUNT_USER_LOGIN));
        result.setUserPassword(accountElement.getChildText(Variables.ACCOUNT_USER_PASSWORD));
        result.setServerHost(accountElement.getChildText(Variables.ACCOUNT_SERVER_HOST));
        result.setServerPort(accountElement.getChildText(Variables.ACCOUNT_SERVER_PORT));
        result.setServerProtocol(accountElement.getChildText(Variables.ACCOUNT_SERVER_PROTOCOL));
        result.setServerSSLStatus(accountElement.getChildText(Variables.ACCOUNT_SERVER_SSL_STATUS));
        
        return result;
    }
    
    private Document getXMLDocumentFromFile(String filename) {
        
        SAXBuilder builder = new SAXBuilder();
        Document result = null;
        
        try {
            result = builder.build(new File(filename));
        } catch (JDOMException ex) {
            Logger.getLogger(XMLFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
}
