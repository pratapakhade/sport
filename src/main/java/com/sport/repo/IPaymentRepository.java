package com.sport.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.sport.entity.PaymentEntity;

	@Repository
	public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {
         
		
	}



