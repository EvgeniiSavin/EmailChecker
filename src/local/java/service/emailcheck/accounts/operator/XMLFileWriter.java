/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.accounts.operator;

import local.java.service.emailcheck.accounts.Account;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.java.service.emailcheck.variables.Variables;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author horch
 */
public class XMLFileWriter {
    
    public XMLFileWriter() {
        
    }
    
    public void writeAccount(Account account) {

        Document xmlAccount = createXMLDocumentFromAccount(account);
        writeToFile(xmlAccount);

    }
    
    private Document createXMLDocumentFromAccount(Account account){
        // Create account properties to XML
        Element accountElement = new Element(Variables.ACCOUNT);
        accountElement.setAttribute(new Attribute(Variables.ACCOUNT_NAME , account.getAccountName()) );
        // Add account properties by element to account
        accountElement.addContent(new Element(Variables.ACCOUNT_USER_LOGIN).addContent(account.getUserLogin()));
        accountElement.addContent(new Element(Variables.ACCOUNT_USER_PASSWORD).addContent(account.getUserPassword()));
        accountElement.addContent(new Element(Variables.ACCOUNT_SERVER_HOST).addContent(account.getServerHost()));
        accountElement.addContent(new Element(Variables.ACCOUNT_SERVER_PORT).addContent(account.getServerPort()));
        accountElement.addContent(new Element(Variables.ACCOUNT_SERVER_PROTOCOL).addContent(account.getServerProtocol()));
        accountElement.addContent(new Element(Variables.ACCOUNT_SERVER_SSL_STATUS).addContent(account.getServerSSLStatus()));

        //Create root Element
        Element rootName = new Element(Variables.ROOT_XML_ACCOUNTS);
        rootName.addContent(accountElement);
        
        return new Document(rootName);
    }
    
    private void writeToFile(Document xmlDocument) {
        try {    
            XMLOutputter output = new XMLOutputter();
            output.output(xmlDocument, new FileWriter(Variables.ACCOUNT_PROPERTIES) );
        } catch (IOException ex) {
            Logger.getLogger(XMLFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
