package org.pc.app.model;

import java.io.Serializable;

import org.pc.userRole.model.UserResponse;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	
	private final UserResponse userResponse;
	
	public JwtResponse(String jwttoken,UserResponse userResponse) {
	this.jwttoken = jwttoken;
	this.userResponse =userResponse;
	}
	
	public String getToken() {
	return this.jwttoken;
	}

	public UserResponse getUserResponse() {
		return userResponse;
	}
	
	

}
