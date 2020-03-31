package com.zp.modules.account.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import cn.afterturn.easypoi.excel.annotation.Excel;
@Entity
@Table(name="m_user")
public class User implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;
	///用户id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Excel(name="ID",orderNum = "0",width = 15)
	private int userId;
	
     //用户名
	@Excel(name="用户名",orderNum = "1",width = 15)
	private String userName;
	
	//用户密码
	@Excel(name="密码",orderNum = "2",width = 15)
	private String password;
	
	//用户创建的时间
	@Excel(name="创建时间",orderNum = "3",width = 15,format = "yyyy-MM-dd")
	private Date createDate;
    
	//删除的状态   1表示删除，0表示未删除
	private int removeState;
	
	@Transient
	private boolean rememberMe;
	
    @Transient
	private List<Role> roles;
	public User() {
		super();
	}

	public int getRemoveState() {
		return removeState;
	}


	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public boolean isRememberMe() {
		return rememberMe;
	}


	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", createDate="
				+ createDate + ", removeState=" + removeState + ", rememberMe=" + rememberMe + ", roles=" + roles + "]";
	}
}
