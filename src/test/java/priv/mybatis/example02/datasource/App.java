/**
 * <p>Title: App.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** 
 * <p>Title: App.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class App {
    public static void main( String[] args ) throws Exception {
    	// 1. 利用Class.forName()方法来加载JDBC驱动程序（Driver）至DriverManager
    	Class.forName("com.mysql.jdbc.Driver");
    	// 2. 从DriverManager中，通过JDBC URL，用户名，密码来获取相应的数据库连接（Connection）
    	// 不同的JDBC驱动程序的URL是不同的，它永远以"jdbc："开始，但后面的内容依照驱动程序类型不同而各异。在获取Connection之后，便可以创建
    	Connection conn = DriverManager.getConnection( 
    		      "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true", // URL
    		      "root", // 用户名
    		      "root" ); // 密码
    	// 3. Statement用以运行SQL语句。下面是一个插入（INSERT）的例子
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO MyTable( name ) VALUES ( 'my name' ) ");
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
