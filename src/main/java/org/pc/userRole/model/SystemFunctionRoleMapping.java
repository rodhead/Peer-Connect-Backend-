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
@Table(name="SYSTEM_FUNCTION_ROLE_MAPPING")
@NamedQuery(name="SystemFunctionRoleMapping.findAll", query="SELECT ua from SystemFunctionRoleMapping ua")
public class SystemFunctionRoleMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SYSTEM_FUNCTION_ROLE_MAPPING_ID")
	private Integer systemFunctionRoleMappingId;
	
	@Column(name="SYSTEM_FUNCTION_ID")
	private Integer systemFunctionId;
	
	@Column(name="ROLE_ID")
	private Integer roleId;
	@Column(name="CREATED_BY")
	private Integer createdBy;
	
	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	public Integer getSystemFunctionRoleMappingId() {
		return systemFunctionRoleMappingId;
	}

	public void setSystemFunctionRoleMappingId(Integer systemFunctionRoleMappingId) {
		this.systemFunctionRoleMappingId = systemFunctionRoleMappingId;
	}

	public Integer getSystemFunctionId() {
		return systemFunctionId;
	}

	public void setSystemFunctionId(Integer systemFunctionId) {
		this.systemFunctionId = systemFunctionId;
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
