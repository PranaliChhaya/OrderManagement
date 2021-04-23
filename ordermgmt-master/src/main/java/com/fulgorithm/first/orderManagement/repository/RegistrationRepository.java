package com.fulgorithm.first.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fulgorithm.first.orderManagement.entity.RegistrationEntity;


	@Repository
	public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long>{
		
	    RegistrationEntity findByUsername(String username);

		Boolean existsByUsername(String username);

		Boolean existsByEmail(String email);

		Boolean deleteByUsername(String username);

	}

