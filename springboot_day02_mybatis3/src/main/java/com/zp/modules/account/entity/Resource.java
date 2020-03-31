package com.zp.modules.account.entity;
/***
 * 资源类
 * @author 25045
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="m_resource")
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//主键id
	private int resourceId;
	//资源路径
	private String resourceUri;
	//资源名
	private String resourceName;
	//资源拥有的角色
	@Transient
	private List<Role> roles;
	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceUri=" + resourceUri + ", resourceName=" + resourceName
				+ ", roles=" + roles + "]";
	}
	public Resource() {
		super();
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getResourceUri() {
		return resourceUri;
	}
	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}
}
