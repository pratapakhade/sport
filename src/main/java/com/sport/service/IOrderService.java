package com.sport.service;

	import java.util.List;

import com.sport.entity.OrderEntity;
import com.sport.exception.InvalidOrderIdException;
import com.sport.exception.OrderNotFoundException;

	public interface IOrderService {
	public OrderEntity addOrder( Long CustId) throws OrderNotFoundException,InvalidOrderIdException;
	public OrderEntity updateOrder(Long id,OrderEntity order)throws OrderNotFoundException,InvalidOrderIdException;
	public OrderEntity removeOrder(Long id) throws InvalidOrderIdException, OrderNotFoundException;
	public List<OrderEntity> getAllOrders();
	public List<OrderEntity> getOrders(Long custId);

	}



