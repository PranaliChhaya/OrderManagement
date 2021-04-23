package com.fulgorithm.first.orderManagement.repository;

	

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

    import com.fulgorithm.first.orderManagement.entity.RegistrationEntityDto;


	@Repository
	public interface RegistrationDtoRepository extends JpaRepository<RegistrationEntityDto, Long> {
		RegistrationEntityDto findByUsername(String username);
		Boolean deleteByUsername(String username);
	}
