/**
 * <p>Title: Test.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/** 
 * <p>Title: Test.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class UnpooledTest {

	public static void main(String[] args) throws SQLException {
		DataSourceFactory factory = new PooledDataSourceFactory();
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true");
		props.put("username", "root");
		props.put("password", "root");
		factory.setProperties(props);
		DataSource dataSource = factory.getDataSource();
		
		Connection connection = dataSource.getConnection();
    	// 3. Statement用以运行SQL语句。下面是一个插入（INSERT）的例子
		Statement stmt = connection.createStatement();
		// 4. 查询（SELECT）的结果存放于结果集（ResultSet）中，可以按照顺序依次访问
		ResultSet rs = stmt.executeQuery("SELECT * FROM MyTable");
		while (rs.next()) {
			int numColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= numColumns; i++) {
				// 与大部分Java API中下标的使用方法不同，字段的下标从1开始
				// 当然，还有其他很多的方式（ResultSet.getXXX()）获取数据
				System.out.println("COLUMN " + i + " = " + rs.getObject(i));
			}
		}
		rs.close();
		stmt.close();
	}

}
