package com.sport.validation;

import com.sport.entity.CustomerEntity;
import com.sport.exception.CustomerNotFoundException;

public class CustomerValidationImpl {
		
		public static CustomerEntity validateUser(CustomerEntity customer) throws CustomerNotFoundException {
			if(customer.getName() != null)
			{
				if(customer.getPassword() != null)
				{
					return customer;
				}
				else throw new CustomerNotFoundException("Password cannot be empty");
			}
			else throw new CustomerNotFoundException("Customer Name cannot be empty");
	}	

	}



