/**
 * <p>Title: SqlSessionFactoryTest.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2019年12月7日
 */
package priv.mybatis.example01;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysqlTest3 {
	
	private static final Logger log = LoggerFactory.getLogger(MysqlTest3.class);;

	public static void main(String[] args) throws IOException {
		String resource = "priv/mybatis/example01/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(reader);
		log.info("create sqlSessionFactory : {}.", sqlSessionFactory);
	}
}

