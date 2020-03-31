package com.zp.modules.account.entity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.zp.modules.account.entity.User;
/**
 * @author 25045
 *         <p>
 *          Description:
 *                             角色类
 *         </p>
 *         <p>
 *         Copyright: Copyright (c) 2019
 *         </p>
 */
@Entity
@Table(name = "m_role")
public class Role{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 角色Id
	private int roleId;
	// 角色名
	private String roleName;
	// 当前角色拥有的用户
	@Transient
	private List<User> users;
	// 当前角色拥有的资源
	@Transient
	private List<Resource> resources;
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + ", resources=" + resources
				+ "]";
	}
     
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
 
	
	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}

	public Role() {
		super();
	}

	public int getRoleId() {
		return roleId;
	}
	

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}
