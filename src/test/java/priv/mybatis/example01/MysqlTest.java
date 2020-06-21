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
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import priv.mybatis.example01.dao.RoleMapper;
import priv.mybatis.example01.domain.Role;

public class MysqlTest {
	
	private static final Log log = LogFactory.getLog(MysqlTest.class);

	public static void main(String[] args) throws IOException {
		String resource = "priv/mybatis/example01/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(reader);
		log.debug("create sqlSessionFactory : " + sqlSessionFactory.toString());

		SqlSession openSession = sqlSessionFactory.openSession();
		RoleMapper mapper = openSession.getMapper(RoleMapper.class);
		Role role = mapper.selectRole(1);
		log.debug("print role: " + role.toString());
	}
}

