package org.pc.userRole.model;

import java.util.List;

public class UserResponse {
	 private Integer userId;
	 private String firstName;
	 private String lastName;
	 private List<String> systemFunction;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getSystemFunction() {
		return systemFunction;
	}
	public void setSystemFunction(List<String> systemFunction) {
		this.systemFunction = systemFunction;
	}
	

}
