package org.pc.userRole.service;

import java.util.List;

import org.pc.userRole.repository.SystemFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemFunctionService {
	
	@Autowired
	SystemFunctionRepository systemFunctionRepository;

	public List<String> findAllSystemFunctionNameByUserId(Integer userId) {
		return systemFunctionRepository.findAllSystemFunctionNameByUserId(userId);
	}

}
