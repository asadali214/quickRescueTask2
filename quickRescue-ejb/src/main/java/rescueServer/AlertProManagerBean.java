package rescueServer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AlertProManagerBean
 */
@Stateless
@LocalBean
public class AlertProManagerBean implements AlertProManagerBeanRemote {

    /**
     * Default constructor. 
     */
    public AlertProManagerBean() {
    	System.out.println("Account Constructor Called!");
    }

}
