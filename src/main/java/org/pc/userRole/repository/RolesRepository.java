package org.pc.userRole.repository;

import javax.transaction.Transactional;

import org.pc.userRole.model.Roles;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface RolesRepository extends CrudRepository<Roles, Integer> {

}
