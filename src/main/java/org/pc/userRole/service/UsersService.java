/**
 * 
 */
package org.pc.userRole.service;

import org.pc.userRole.model.Users;
import org.pc.userRole.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author misbahRahman
 *
 */
@Service
public class UsersService {
	
	@Autowired
	UsersRepository usersRepository;

	public Users getUserByUserName(String userName) {
		return usersRepository.getUserByUserName(userName.toLowerCase().trim());
	}

}
