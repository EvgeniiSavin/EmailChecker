/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoreOfService;

import java.util.UUID;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author horch
 */
public class DataOperator {
    
    public void writeToXML() {
        Document xmlRepresent = new Document();

        // New User
        Element userElement = new Element("user");
        userElement.setAttribute(new Attribute("uuid", UUID.randomUUID().toString()));
        // New username of User
        Element username = new Element("username");
        username.addContent("test1");
        // New password of User
        Element password = new Element("password");
        password.addContent("pess_test");
        // New imap server of User
        Element imapServer = new Element("server");
        imapServer.addContent("imap_server");
        
        // Add all elements of User to User element
        userElement.addContent(username);
        userElement.addContent(password);
        userElement.addContent(imapServer);
        
        // Add User element to XML Document
        xmlRepresent.addContent(userElement);
        
        XMLOperator xmlOperator = new XMLOperator();
        xmlOperator.writeToXML(xmlRepresent, "test");
        
    }
    
}
