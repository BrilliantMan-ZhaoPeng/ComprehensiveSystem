package com.zp.modules.account.entity;
/**
 * @author 25045
 * <p>Description:用户角色类</p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="m_user_role")
public class UserRole {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  //主键Id
	  private int userRoleId;
	  //用户id
	  private int userId;
	  //角色Id
	  private int roleId;
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
