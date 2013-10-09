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
    
    public void showDocumentIntConsole(Document xmlDocument) {
        
        XMLOutputter output = new XMLOutputter();
        String stringXMLDocument;
        stringXMLDocument = output.outputString(xmlDocument);
        
        System.out.println(stringXMLDocument);
        
    }
    
    public void writeDocumentToFile(Document xmlDocument) {
        
    }
    
}
