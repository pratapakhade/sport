package com.test.product;




import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sport.entity.PaymentEntity;
import com.sport.exception.PaymentNotFoundException;
import com.sport.repo.IPaymentRepository;
import com.sport.service.IPaymentService;



@SpringBootTest
class PaymentServiceImplTest {
	
		@MockBean
		IPaymentRepository iPaymentRepository;
		
		@Autowired
		IPaymentService iPaymentService;		
		
		@Test
		void testAddPayment01() {
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
			
			Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
	        assertNull(paymentEntity);
		}
		
		@Test
		void testRemovePayment01() throws PaymentNotFoundException{
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
	        
	        Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
	        iPaymentRepository.deleteById(paymentEntity.getId());
	        assertNull(paymentEntity);
	        
	        // Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
	        //iPaymentRepository.deleteById(paymentEntity.getId());
	        //assertNull(paymentEntity);
		}
		
		@Test
		void testUpdatPayment01() throws PaymentNotFoundException{
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
	        
	        iPaymentRepository.save(paymentEntity);
	        paymentEntity.setStatus("Not Sucess");
			iPaymentRepository.save(paymentEntity);
	        
	        assertNull(paymentEntity);
		}
		
		@Test
		void testGetPaymentDetails01() throws PaymentNotFoundException{
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
	        
			iPaymentRepository.save(paymentEntity);
		    iPaymentRepository.findById(23L);
		    assertNotEquals(paymentEntity,new PaymentEntity());
		}
		
		@Test
		void testGetAllPaymentDetails01() {
			PaymentEntity paymentEntity1 = new PaymentEntity();
			paymentEntity1.setId((long)23);
	        paymentEntity1.setType("Online");
	        paymentEntity1.setStatus("Sucess");
	        paymentEntity1.setCardEntity(null);
	        
	        PaymentEntity paymentEntity2 = new PaymentEntity();
			paymentEntity2.setId((long)24);
	        paymentEntity2.setType("NetBanking");
	        paymentEntity2.setStatus("Sucess");
	        paymentEntity2.setCardEntity(null);
	        
	        List<PaymentEntity> paymentList= new ArrayList<>();
	        paymentList.add(paymentEntity1);
	        paymentList.add(paymentEntity2);
	        
	        Mockito.when(iPaymentRepository.findAll()).thenReturn(paymentList);
			assertEquals(paymentList, new PaymentEntity());
	        
	        //Mockito.when(iPaymentRepository.findAll().thenReturn(paymentList));
			//assertEquals(paymentList,iPaymentService.getAllPaymentDetails() );
		}
		
}