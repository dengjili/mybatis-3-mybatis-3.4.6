/**
 * <p>Title: Test.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource.factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PoolState;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/** 
 * <p>Title: Test.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class PooledTest {

	public static void main(String[] args) throws SQLException {
		DataSourceFactory factory = new PooledDataSourceFactory();
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true");
		props.put("username", "root");
		props.put("password", "root");
		factory.setProperties(props);
		DataSource dataSource = factory.getDataSource();
		
		PooledDataSource pooledDataSource= (PooledDataSource) dataSource;
		PoolState poolState = pooledDataSource.getPoolState();
		System.out.println(poolState);
		for (int i = 1; i <= 10; i++) {
			pooledDataSource.getConnection();
		}
		Connection connection = pooledDataSource.getConnection();
		connection.close();
		System.out.println(poolState);
	}

}
