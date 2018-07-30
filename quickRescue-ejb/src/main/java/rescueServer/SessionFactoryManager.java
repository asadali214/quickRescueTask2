package rescueServer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryManager {
	public static SessionFactory factory=null;
	
	public static SessionFactory getSessionfac() {
		
		if(factory==null) {
			try {
				factory = new Configuration().configure("hibernate.cfg.xml").addPackage("entities").buildSessionFactory();
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
		}
			
		return factory;
		
	}
}
