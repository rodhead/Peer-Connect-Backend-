package org.pc.app.utility;

import java.util.List;

import org.pc.userRole.model.SystemFunction;
import org.pc.userRole.model.UserResponse;
import org.pc.userRole.model.Users;
import org.pc.userRole.service.SystemFunctionService;
import org.pc.userRole.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseFormationUtil {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	SystemFunctionService systemFunctionService;
	
	public UserResponse formUserResponse(String userName) {
		UserResponse userResponse = null;
		if(null != userName) {
			userResponse = new UserResponse();
			Users users = usersService.getUserByUserName(userName);
			if(null != users) {
				userResponse.setFirstName(users.getFirstName());
				userResponse.setLastName(users.getLastName());
				userResponse.setUserId(users.getUserId());
				List<String> systemFunctionNames =systemFunctionService.findAllSystemFunctionNameByUserId(users.getUserId());
				if(null != systemFunctionNames && !systemFunctionNames.isEmpty()) {
					userResponse.setSystemFunction(systemFunctionNames);
				}
			}
		}
		return userResponse;
	}

}
