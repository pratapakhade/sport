package com.sport.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sport.entity.AddressEntity;

	@Repository
	public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

	}
	//


