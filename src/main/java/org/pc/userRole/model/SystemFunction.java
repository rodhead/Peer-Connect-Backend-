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
@Table(name="SYSTEM_FUNCTION")
@NamedQuery(name="SystemFunction.findAll", query="SELECT ua from SystemFunction ua")
public class SystemFunction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SYSTEM_FUNCTION_ID")
	private Integer systemFunctionId;
	
	@Column(name="SYSTEM_FUNCTION_NAME")
	private String systemFunctionName;
	
	@Column(name="SYSTEM_FUNCTION_DESCRIPTION")
	private String systemFunctionDescription;
	
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	@Column(name="CREATED_BY")
	private Integer createdBy;
	
	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="UPDATED_BY")
	private Integer updatedBy;
	
	@Column(name="UPDATED_DATE")
	private Timestamp updatedDate;

	public Integer getSystemFunctionId() {
		return systemFunctionId;
	}

	public void setSystemFunctionId(Integer systemFunctionId) {
		this.systemFunctionId = systemFunctionId;
	}

	public String getSystemFunctionName() {
		return systemFunctionName;
	}

	public void setSystemFunctionName(String systemFunctionName) {
		this.systemFunctionName = systemFunctionName;
	}

	public String getSystemFunctionDescription() {
		return systemFunctionDescription;
	}

	public void setSystemFunctionDescription(String systemFunctionDescription) {
		this.systemFunctionDescription = systemFunctionDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}
