/**
 * <p>Title: DataSourceImpl.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource.unpooled;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import priv.mybatis.example02.datasource.SourceImplWrapper;

/** 
 * <p>Title: DataSourceImpl.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class DataSourceImpl extends SourceImplWrapper {
	
	private static Map<String, Boolean> registeredDrivers = new ConcurrentHashMap<>();

	static {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
	    while (drivers.hasMoreElements()) {
	        Driver driver = drivers.nextElement();
	    	registeredDrivers.put(driver.getClass().getName(), true);
	    }
	}
	  
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public DataSourceImpl(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return getConnection(username, password);
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		 return doGetConnection(username, password);
	}

	private Connection doGetConnection(String username, String password) throws SQLException {
		initializeDriver();
		Connection connection = DriverManager.getConnection(url, username, password);
	    return connection;
	}

	private synchronized void initializeDriver() throws SQLException {
		if (!registeredDrivers.containsKey(driver)) {
			try {
				Class.forName(driver);
				registeredDrivers.put(driver, true);
			} catch (Exception e) {
				throw new SQLException("Error setting driver on UnpooledDataSource. Cause: " + e);
			}
		}
	}
}
