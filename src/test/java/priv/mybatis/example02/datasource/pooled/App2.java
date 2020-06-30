/**
 * <p>Title: App.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource.pooled;

import java.sql.Connection;

/** 
 * <p>Title: App.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class App2 {

	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true";
    	String username = "root";
    	String password = "root";
    	
    	// 1. 使用数据源
    	PooledSourceImpl dataSource = new PooledSourceImpl(driver, url, username, password);
    	
    	for (int i = 0; i < 21; i++) {
    		Connection connection = dataSource.getConnection();
    		System.out.println(connection.hashCode());
    	}
    	
    	dataSource.printStatus();
	}

}
