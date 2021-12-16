package com.sport.service;




	import java.util.List;

import com.sport.entity.PaymentEntity;
import com.sport.exception.PaymentNotFoundException;

	public interface IPaymentService {
		
		public PaymentEntity addPayment(PaymentEntity payment);
		public PaymentEntity removePayment(Long id);
		public PaymentEntity updatePayment(Long id, PaymentEntity payment);
		public PaymentEntity getPaymentDetails(Long paymentID) throws PaymentNotFoundException;	
		public List<PaymentEntity> getAllPaymentDetails();
	}



