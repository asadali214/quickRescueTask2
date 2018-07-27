package rescueClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceManager {

	private static String MODULE = "quickRescue-ejb";
	private static InitialContext context;
	static HashMap<String, Object> services = new HashMap<String, Object>();

	private static Properties loadProperties() throws IOException {
		InputStream inputStream = ServiceManager.class.getClassLoader()
				.getResourceAsStream("jboss-ejb-client.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
//		properties.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
//		properties.put("java.naming.factory.initial", "org.wildfly.naming.client.WildFlyInitialContextFactory");
//		properties.put("java.naming.provider.url", "remote+http://127.0.0.1:8080");
//		properties.put("jboss.naming.client.ejb.context", "true");
//		properties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
		return properties;
	}

	private static InitialContext loadContext() throws NamingException, IOException {
		if (context == null) {
			context = new InitialContext(loadProperties());
		}
		return context;
	}

	public static Object getService(Class<?> clazz) throws NamingException, IOException {
		String serviceName = clazz.getName();
		Object service = services.get(serviceName);
		if (service == null) {// if not already cached
			String name = "ejb:/" + MODULE + "//" + clazz.getSimpleName() + "!" + clazz.getName() + "Remote";
			service = loadContext().lookup(name);
			services.put(serviceName, service);// cache it
		}
		return service;
	}
}