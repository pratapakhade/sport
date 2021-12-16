package com.sport.service;


	
	
	import java.time.LocalDate;
	import java.util.List;

import com.sport.entity.Admin;
import com.sport.entity.OrderEntity;
import com.sport.exception.AdminNotFoundException;
import com.sport.exception.CustomerNotFoundException;

	public interface IAdminService {

		public Admin insertAdmin(Admin admin);
		public Admin updateAdmin(Long id,Admin admin)throws AdminNotFoundException,Exception;
		public Admin deleteAdmin(Long id) throws AdminNotFoundException ,Exception;
		public List<OrderEntity> getAllOrders(Long custId)  throws CustomerNotFoundException;
		public List<OrderEntity> getOrders(Long custId) throws CustomerNotFoundException;
	    ;
	}


