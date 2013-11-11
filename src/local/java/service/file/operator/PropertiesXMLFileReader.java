/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.file.operator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.java.service.emailcheck.variables.Variables;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author horch
 */
public class PropertiesXMLFileReader {
    
    private String filename;
    
    public PropertiesXMLFileReader() {
        this.filename = Variables.ACCOUNT_PROPERTIES;
    }
    
    public Document getXMLDocumentFromFile() {
        SAXBuilder builder = new SAXBuilder();
        Document result = null;
        
        try {
            result = builder.build(new File(filename));
        } catch (JDOMException ex) {
            Logger.getLogger(PropertiesXMLFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesXMLFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;

    }
    
}
