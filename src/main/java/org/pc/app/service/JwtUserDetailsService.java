package org.pc.app.service;

import java.util.ArrayList;
import java.util.Base64;

import org.pc.userRole.model.Users;
import org.pc.userRole.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service()
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsersService userService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users usd=  userService.getUserByUserName(username);
		if (usd.getUserName().equals(username)) {
			return new User(usd.getUserName(), usd.getUserPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
