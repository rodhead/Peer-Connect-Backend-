package org.pc.app.security;
/**
 * 
 *//*
package org.bottomhalf.ec.security;

import java.util.ArrayList;
import java.util.List;

import org.bottomhalf.ec.constants.ApplicationConstant;
import org.bottomhalf.ec.service.SecurityLogWriterService;
import org.bottomhalf.ec.user.modelDAO.Users;
import org.bottomhalf.ec.user.serviceIMPL.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

*//**
 * @author rahman
 *
 *//*
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	SecurityLogWriterService securityLogWriterService;
	@Autowired
	UsersService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		List<GrantedAuthority> grantAuth = new ArrayList<>();
		String userName = authentication.getName();
		String ipAdddress = ((WebAuthenticationDetails)authentication.getDetails()).getRemoteAddress();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//UserLog
		if(authentication.getName().indexOf("\\") > 0) {
			userName = authentication.getName().substring(authentication.getName().indexOf("\\")+1);
		}else if(authentication.getName().indexOf("/") > 0) {
			userName = authentication.getName().substring(authentication.getName().indexOf("/")+1);
		}
		
		Users user = userService.getUserByUserName(userName);
		securityLogWriterService.info("IP address "+ipAdddress+" is attempting to login with username "+userName);
		if(null != user) {
			//SYSTEM ADMIN AUTHENTICATION
			if(user.getUserName() != null && user.getUserName().equalsIgnoreCase(ApplicationConstant.SUPER_USER)) {
				
			}
			
			//USER AUTHENTICATION BY STATUS
			if(user.getStatus().equalsIgnoreCase(ApplicationConstant.STATUS_ACTIVE)) {
				//get Role implementation
				if(user.getUserPassword() != null && !user.getUserPassword().isEmpty() && encoder.matches(authentication.getCredentials().toString(), user.getUserPassword())) {
					checkLastLoginDate(user);
					checkLastPasswordUpdateDate(user);
					checkForLoginAttempts(user);
					securityLogWriterService.info("$Authentication Successfull$ "+userName+" $IP="+ipAdddress+"$ has been authorized to login.");
					authentication = new UsernamePasswordAuthenticationToken(userName, authentication.getCredentials(), grantAuth);
				}
				else {
					securityLogWriterService.info("$"+userName+"$IP="+ipAdddress+"$ had input password mismatched with DB Password.");
				}
			}else {
				securityLogWriterService.info("$Authentication failed$"+userName+"$IP="+ipAdddress+"$ status is "+(user.getStatus()!=null?user.getStatus():"BLANK")+" in DB.");
				throw new AuthenticationCredentialsNotFoundException("Your account has been disabled. PLease contact bottomhalf support desk( bottomhalfsupportdesk@bottomhalf.in");
			}
		}
		else {
			securityLogWriterService.info("$"+userName+"$IP="+ipAdddress+"$ is not presemt in DB");
			throw new AuthenticationCredentialsNotFoundException("Incorrect Username or Password");
		}
		return authentication;
	}

	private void checkForLoginAttempts(Users user) {
		// TODO Auto-generated method stub
		
	}

	private void checkLastPasswordUpdateDate(Users user) {
		// TODO Auto-generated method stub
		
	}

	private void checkLastLoginDate(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
*/