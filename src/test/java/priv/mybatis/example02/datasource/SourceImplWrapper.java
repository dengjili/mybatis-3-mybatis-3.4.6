/**
 * <p>Title: DataSourceImpl.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

/** 
 * <p>Title: DataSourceImpl.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public abstract class SourceImplWrapper implements DataSource {
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		 return DriverManager.getLogWriter();
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return DriverManager.getLoginTimeout();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return Logger.getGlobal();
	}

	@Override
	public void setLogWriter(PrintWriter printWriter) throws SQLException {
		DriverManager.setLogWriter(printWriter);
	}

	@Override
	public void setLoginTimeout(int loginTimeout) throws SQLException {
		DriverManager.setLoginTimeout(loginTimeout);
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		return null;
	}
}
