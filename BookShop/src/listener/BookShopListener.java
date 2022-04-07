package listener;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import utils.DBUtils;

public class BookShopListener implements ServletContextListener  {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		Properties properties = new Properties();
		properties.setProperty("DRIVER", context.getInitParameter("DRIVER"));
		properties.setProperty("URL", context.getInitParameter("URL"));
		properties.setProperty("USER", context.getInitParameter("USER"));
		properties.setProperty("PASSWORD", context.getInitParameter("PASSWORD"));
		DBUtils.setProperties(properties);
	}

}
