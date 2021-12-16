package com.sport.service;


	import java.util.List;

import com.sport.entity.CustomerEntity;
import com.sport.exception.CustomerNotFoundException;



	public interface ICustomerService {

			public CustomerEntity addCustomer(CustomerEntity customer) throws CustomerNotFoundException;
			public CustomerEntity signIn(CustomerEntity customer) throws CustomerNotFoundException;
			public String signOut(CustomerEntity customer);
			public CustomerEntity removeCustomer(Long custId) throws CustomerNotFoundException;
			public CustomerEntity updateCustomer(Long custId,CustomerEntity customer) throws CustomerNotFoundException;
			public CustomerEntity getCustomer(Long custId) throws CustomerNotFoundException;
			public List<CustomerEntity> getAllCustomers(); 
	}



