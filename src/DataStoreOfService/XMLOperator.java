/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoreOfService;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author horch
 */
public class XMLOperator {
    
    public void showDocumentIntConsole(Document xml) {
        
        XMLOutputter output = new XMLOutputter();
        try {
            output.output(xml, System.out);
        } catch (IOException ex) {
            Logger.getLogger(XMLOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
