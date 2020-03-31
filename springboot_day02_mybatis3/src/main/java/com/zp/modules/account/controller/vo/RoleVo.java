package com.zp.modules.account.controller.vo;

import java.util.Arrays;
public class RoleVo {
	private int roleId;
	private String roleName;
	private int[] resources;

	@Override
	public String toString() {
		return "RoleVo [roleId=" + roleId + ", roleName=" + roleName + ", resources=" + Arrays.toString(resources)
				+ "]";
	}

	public RoleVo() {
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

	public int[] getResources() {
		return resources;
	}

	public void setResources(int[] resources) {
		this.resources = resources;
	}
}
