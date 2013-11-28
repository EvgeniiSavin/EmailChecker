/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.accounts;

import local.java.service.file.operator.PropertiesXMLFileWriter;
import local.java.service.variables.Variables;
import local.java.service.file.operator.PropertiesXMLFileReader;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author horch
 */
public class AccountOperator {
    
    public AccountOperator() {
        
    }
    
    public Account getAccount() {
        Account account = 
                getAccountFromXMLDocument( new PropertiesXMLFileReader().getXMLDocumentFromFile() );
        
        return account;
    }
    
    public void writeAccountToXML(Account account) {
        
        PropertiesXMLFileWriter documentWriter = new PropertiesXMLFileWriter();
        
        documentWriter.writeDocument( createXMLDocumentFromAccount(account) );
        
    }
    
    private Account getAccountFromXMLDocument(Document xmlDocument) {
        
        Account result = new Account();
        Element rootElement = xmlDocument.getRootElement();
        Element accountElement = rootElement.getChild(Variables.ACCOUNT);
        
       
        result.setUserLogin(accountElement.getChildText(Variables.ACCOUNT_USER_LOGIN));
        result.setUserPassword(accountElement.getChildText(Variables.ACCOUNT_USER_PASSWORD));
        result.setServerHost(accountElement.getChildText(Variables.ACCOUNT_SERVER_HOST));
        result.setServerPort(accountElement.getChildText(Variables.ACCOUNT_SERVER_PORT));
        result.setServerProtocol(accountElement.getChildText(Variables.ACCOUNT_SERVER_PROTOCOL));
        result.setServerSSLStatus(accountElement.getChildText(Variables.ACCOUNT_SERVER_SSL_STATUS));
        
        return result;
    }
    
    private Document createXMLDocumentFromAccount(Account account) {
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
    
    
}
