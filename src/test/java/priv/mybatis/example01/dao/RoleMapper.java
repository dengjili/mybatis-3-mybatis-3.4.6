/**
 * <p>Title: RoleMapper.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2019年12月7日
 */
package priv.mybatis.example01.dao;

import priv.mybatis.example01.domain.Role;

public interface RoleMapper {
	Role selectRole(int id);
}
