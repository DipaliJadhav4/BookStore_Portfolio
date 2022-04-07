package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {
	

	private static Properties properties;

	public static void setProperties(Properties properties) {
		DBUtils.properties=properties;
		
	}
	
	public static Connection getConnection() throws Exception
	{
		Class.forName(properties.getProperty("DRIVER"));
			
		return DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"));
		
	}

}
