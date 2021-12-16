package com.sport.service;


	import java.util.List;

import com.sport.entity.CartEntity;
import com.sport.exception.CartException;
	

	public interface ICartService {
		
			public CartEntity addCart(Long custId, Long prodID) throws CartException;
			public CartEntity deleteCart(Long id) throws CartException;
			public List<CartEntity> getallCartDetails();
			public List<CartEntity> getCart(Long custId);

	}



