package com.fulgorithm.first.orderManagement.repository;

	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.fulgorithm.first.orderManagement.entity.ERole;
import com.fulgorithm.first.orderManagement.entity.Role;


	@Repository
	public interface RoleRepository extends JpaRepository<Role, Long> {
		Role findByName(ERole name);

	}