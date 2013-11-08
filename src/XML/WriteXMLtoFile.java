/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Properties.AccountProperties;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author horch
 */
public class WriteXMLtoFile {
    
    public WriteXMLtoFile() {
        
    }
    
    public void writeAccountProperties(AccountProperties accountProp) {
        // Create account properties to XML
        Element accountElement = new Element("account");
        accountElement.setAttribute(new Attribute("name" , accountProp.getAccountName()) );
        // Add account properties by element to account
        accountElement.addContent(new Element("userLogin").addContent(accountProp.getUserLogin()));
        accountElement.addContent(new Element("userPassword").addContent(accountProp.getUserPassword()));
        accountElement.addContent(new Element("serverHost").addContent(accountProp.getServerHost()));
        accountElement.addContent(new Element("serverPort").addContent(accountProp.getServerPort()));
        accountElement.addContent(new Element("serverProtocol").addContent(accountProp.getServerProtocol()));
        accountElement.addContent(new Element("serverSSLStatus").addContent(accountProp.getServerSSLStatus()));

        //Create root Element
        Element rootName = new Element("accounts");
        rootName.addContent(accountElement);
        Document xmlAccountProp = new Document(rootName);
        
        writeToFile(xmlAccountProp);
    }
    
    private void writeToFile(Document xmlDocument) {
        try {    
            XMLOutputter output = new XMLOutputter();
            output.output(xmlDocument, new FileWriter("properties") );
        } catch (IOException ex) {
            Logger.getLogger(WriteXMLtoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
