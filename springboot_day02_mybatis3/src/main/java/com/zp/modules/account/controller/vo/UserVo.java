package com.zp.modules.account.controller.vo;

import java.util.Arrays;

public class UserVo {
	private int userId;
	private String userName;
	private String password;
	private int [] roles;
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roles="
				+ Arrays.toString(roles) + "]";
	}
	public UserVo() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int[] getRoles() {
		return roles;
	}
	public void setRoles(int[] roles) {
		this.roles = roles;
	}
}
