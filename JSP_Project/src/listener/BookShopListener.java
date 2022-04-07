package listener;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import utils.DBUtils;

public class BookShopListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		Properties properties = new Properties();
		properties.getProperty("DRIVER", context.getInitParameter("DRIVER"));
		properties.getProperty("URL", context.getInitParameter("URL"));
		properties.getProperty("USER", context.getInitParameter("USER"));
		properties.getProperty("PASSWORD", context.getInitParameter("PASSWORD"));
		DBUtils.setProperties(properties);
		
	}

}
