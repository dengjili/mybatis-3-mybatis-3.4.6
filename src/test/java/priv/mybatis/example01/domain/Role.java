/**
 * <p>Title: Role.java</p>
 * <p>Description: </p>
 * @author    dengjili
 * @date      2020年6月21日  
 */
package priv.mybatis.example01.domain;

/** 
 * <p>Title: Role.java</p>  
 * <p>Description: </p>  
 * @author    dengjili
 * @date      2020年6月21日  
 */
public class Role {

	private int id;
	private String name;
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
}