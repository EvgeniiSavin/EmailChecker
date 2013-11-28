/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local.java.service.emailcheck.tray;

import local.java.service.variables.Variables;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user102
 */
public class SystemTrayApplication {
    
    private SystemTray tray;
    private TrayIcon trayIcon;
    private Image image;
    private MenuTray menuTray;
    
    /**
     *
     */
    public SystemTrayApplication() {
        
        image = Toolkit.getDefaultToolkit().createImage(Variables.TRAY_ICON);
        menuTray = new MenuTray();
        
        trayIcon = new TrayIcon(image, Variables.NAME_ICON_TRAY);
        trayIcon.setPopupMenu(menuTray.popupMenu);
        
        tray = SystemTray.getSystemTray();
        
        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(SystemTrayApplication.class.getName()).log(Level.SEVERE, "IconTray is not correct", ex);
        }

    }
    
    public void showInfoMessage(String message) {
        // For test
        System.out.println(message);
        
        // Show info message
        trayIcon.displayMessage("Email info", message, TrayIcon.MessageType.INFO);
        
    }
    
}