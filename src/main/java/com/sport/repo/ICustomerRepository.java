package com.sport.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sport.entity.CustomerEntity;


	@Repository
	public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
		
	}
	//


