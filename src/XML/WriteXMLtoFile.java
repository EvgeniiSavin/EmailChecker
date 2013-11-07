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
        
            //Create root Element
            Element rootName = new Element("accounts");
            Document xmlAccountProp = new Document(rootName);
            
            
            Element accountElement = new Element("account");
            rootName.addContent(accountElement);
            
            accountElement.setAttribute(new Attribute("name" , accountProp.getAccountName()) );
            
            accountElement.addContent(new Element("UserProperties"));
            accountElement.addContent(new Element("ServerProperties"));
            
            FileWriter writer = null;
        try {
            writer =  new FileWriter("properties");
        } catch (IOException ex) {
            Logger.getLogger(WriteXMLtoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {    
            XMLOutputter output = new XMLOutputter();
            output.output(xmlAccountProp, writer);
        } catch (IOException ex) {
            Logger.getLogger(WriteXMLtoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
