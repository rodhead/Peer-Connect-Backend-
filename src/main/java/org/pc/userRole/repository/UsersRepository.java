package org.pc.userRole.repository;

import org.pc.userRole.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsersRepository extends CrudRepository<Users, Integer>{

	@Query("SELECT us from Users us where us.userName =:userName")
	Users getUserByUserName(@Param("userName") String userName);

}
