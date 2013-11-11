/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.file.operator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.java.service.emailcheck.variables.Variables;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author horch
 */
public class PropertiesXMLFileWriter {
    
    private String filename;
    
    public PropertiesXMLFileWriter() {
        this.filename = Variables.ACCOUNT_PROPERTIES;
    }
    
    public void writeDocument(Document xmlDocument) {
        try {    
            XMLOutputter output = new XMLOutputter();
            output.output(xmlDocument, new FileWriter(filename) );
        } catch (IOException ex) {
            Logger.getLogger(PropertiesXMLFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
