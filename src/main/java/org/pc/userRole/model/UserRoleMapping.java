package org.pc.userRole.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE_MAPPING")
@NamedQuery(name="UserRoleMapping.findAll", query="SELECT ua from UserRoleMapping ua")
public class UserRoleMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ROLE_MAPPING_ID")
	private Integer userRoleMappingId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="ROLE_ID")
	private Integer roleId;
	
	@Column(name="CREATED_BY")
	private Integer createdBy;
	
	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	public Integer getUserRoleMappingId() {
		return userRoleMappingId;
	}

	public void setUserRoleMappingId(Integer userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
