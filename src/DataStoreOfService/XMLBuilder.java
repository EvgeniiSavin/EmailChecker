/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoreOfService;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author user102
 */
public class XMLBuilder {
    
    XMLBuilder() {
        
    }
    
    public Document createXMLDocFromUser(UserPermission userPermission) {
        
        Document xmlRepresent = new Document();
        
        //Create root element 
        Element rootElementProfileOfUser = new Element("UserPermission");
        rootElementProfileOfUser.setAttribute("profile", userPermission.getNameProfile());
        
        // Create username element
        Element subElementUsername = createSubElement("username", userPermission.getUsername());
        // Create password element
        Element subElementPassword = createSubElement("password", userPermission.getPassword());
        // Create server of user profile
        Element subElementServerOfProfile = createSubElement("server", userPermission.getServer());
        
        // Add submission Element to Root Element
        rootElementProfileOfUser.addContent(subElementUsername);
        rootElementProfileOfUser.addContent(subElementPassword);
        rootElementProfileOfUser.addContent(subElementServerOfProfile);
        
        // Add root element to Document
        xmlRepresent.addContent(rootElementProfileOfUser);
        
        return xmlRepresent;
    }
    
    private Element createSubElement(String nameElement, String contentOfElement) {
        
        Element result = new Element(nameElement);
        result.addContent(contentOfElement);
        
        return result;
    }
    
    
}
