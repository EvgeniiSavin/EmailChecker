/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Permission.UserPermission;
import org.jdom2.Document;

/**
 *
 * @author horch
 */
public class DataAccessProvider {
    
    public void addUserToDataStore(UserPermission userPermission) {
        // Create XML represent of user permission
        XMLBuilder xmlBuilder = new XMLBuilder();
        Document XMLUserPermission = xmlBuilder.createXMLDocFromUser(userPermission);
        
        // Show document
        XMLOperator xmlOperator = new XMLOperator();
        xmlOperator.showDocumentIntConsole(XMLUserPermission);
    }
    
}
