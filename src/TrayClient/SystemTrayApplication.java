/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrayClient;

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
    
    SystemTray tray;
    TrayIcon trayIcon;
    Image image;
    MenuTray menuTray;
    
    public SystemTrayApplication() {
        
        this.image = Toolkit.getDefaultToolkit().getImage(StaticParameters.PATH_ICON_TRAY);
        this.menuTray = new MenuTray();
        this.trayIcon = new TrayIcon(image, StaticParameters.NAME_ICON_TRAY);
        this.trayIcon.setPopupMenu(menuTray.popupMenu);
        
        this.tray = SystemTray.getSystemTray();
        
        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(SystemTrayApplication.class.getName()).log(Level.SEVERE, "IconTray is not correct", ex);
        }
        
    }
    
}