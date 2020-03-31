package com.zp.modules.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 25045
 * <p>Description:角色资源类 </p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
@Entity
@Table(name="m_role_resource")
public class RoleResource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//主键
    private int roleResourceId;
	//角色Id
    private int roleId;
    //资源Id
    private int resourceId;
	public int getRoleResourceId() {
		return roleResourceId;
	}
	public void setRoleResourceId(int roleResourceId) {
		this.roleResourceId = roleResourceId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
}
