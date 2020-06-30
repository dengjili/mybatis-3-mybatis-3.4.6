/**
 * <p>Title: App.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource.pooled;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** 
 * <p>Title: App.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class App {

	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true";
    	String username = "root";
    	String password = "root";
    	
    	// 1. 使用数据源
    	PooledSourceImpl dataSource = new PooledSourceImpl(driver, url, username, password);
    	Connection connection = dataSource.getConnection();
    	// 3. Statement用以运行SQL语句。下面是一个插入（INSERT）的例子
		Statement stmt = connection.createStatement();
		//stmt.executeUpdate("INSERT INTO MyTable( name ) VALUES ( 'my name' ) ");
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
		
		dataSource.printStatus();
	}

}
