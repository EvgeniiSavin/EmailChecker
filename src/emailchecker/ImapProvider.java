/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import javax.mail.Provider;

/**
 *
 * @author user102
 */
public class ImapProvider {
    
    private Provider imapProvider;
    private String PROTOCOL = "imap";
    private String CLASSNAME = "com.sun.mail.imap.IMAPStore";
    private String VENDOR = "";
    private String VERSION = "";
            
    ImapProvider() {
        imapProvider = new Provider(Provider.Type.STORE, PROTOCOL, CLASSNAME, VENDOR, VERSION);
    }
    
    public Provider getProvider() {
        return imapProvider;
    }
    
}
