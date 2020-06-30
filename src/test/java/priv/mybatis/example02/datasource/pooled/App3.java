/**
 * <p>Title: App.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月24日  
 */
package priv.mybatis.example02.datasource.pooled;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

/** 
 * <p>Title: App.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月24日  
 */
public class App3 {

	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true";
    	String username = "root";
    	String password = "root";
    	
    	// 1. 使用数据源
    	PooledSourceImpl dataSource = new PooledSourceImpl(driver, url, username, password);
    	
    	new Thread(() -> {
			for (int j = 0; j < 100; j++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dataSource.printStatus();
			}
		}).start();
    	
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				for (int j = 0; j < 10; j++) {
					try {
						Connection connection = dataSource.getConnection();
						System.out.println(connection.hashCode());
						Thread.sleep(new Random().nextInt(1000));
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
