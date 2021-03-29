package org.pc.userRole.repository;

import java.util.List;

import org.pc.userRole.model.SystemFunction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SystemFunctionRepository extends CrudRepository<SystemFunction, Integer> {

	@Query("Select sf.systemFunctionName from SystemFunction sf where sf.systemFunctionId in("
			+ " Select sfrm.systemFunctionId from SystemFunctionRoleMapping sfrm where sfrm.roleId in("
			+ " select urm.roleId from UserRoleMapping urm where urm.userId =:userId))")
	List<String> findAllSystemFunctionNameByUserId(@Param("userId") Integer userId);

}
