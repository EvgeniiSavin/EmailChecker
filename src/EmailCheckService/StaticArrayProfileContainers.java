/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailCheckService;

import java.util.ArrayList;

/**
 *
 * @author user102
 */
public class StaticArrayProfileContainers {
    
    private static ArrayList<ProfileContainer> staticProfileContainer =
            new ArrayList<ProfileContainer>();
    
    StaticArrayProfileContainers() {
        
    }
    
    public static void addProfileContainer(ProfileContainer objectProfileContainer) {
        staticProfileContainer.add(objectProfileContainer);
    }
    
    public static ProfileContainer getProfileContainer(int positionProfileContainer) {
        return staticProfileContainer.get(positionProfileContainer);
    }
    
    public static boolean isEmpty() {
        return staticProfileContainer.isEmpty();
    }

}
