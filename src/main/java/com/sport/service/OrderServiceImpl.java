package com.sport.service;


	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.sport.entity.CartEntity;
import com.sport.entity.OrderEntity;
import com.sport.exception.InvalidOrderIdException;
import com.sport.exception.OrderNotFoundException;
import com.sport.repo.ICartRepository;
import com.sport.repo.IOrderRepository;


	@Service
	public class OrderServiceImpl implements IOrderService {

		static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
		@Autowired 
		private IOrderRepository iOrderRepository; 
		
		@Autowired 
		private ICartRepository iCartRepository;
	
		
		@Override
		public OrderEntity updateOrder(Long id,OrderEntity order)throws OrderNotFoundException{
			LOGGER.info("updateOrder() service is initiated");
			OrderEntity existOrd= iOrderRepository.findById(id).orElse(null);
			if (existOrd == null)
				throw new OrderNotFoundException("orderIdIncorrect");
			else 
				existOrd = iOrderRepository.save(order);
			LOGGER.info("updateOrder() service has executed");
			return existOrd;
		}
		@Override
		public OrderEntity removeOrder(Long id) throws OrderNotFoundException{
			LOGGER.info("removeOrder() service is initiated");
			OrderEntity ordEntity = iOrderRepository.findById(id).orElse(null);
			if (ordEntity == null)
				throw new OrderNotFoundException("orderIdIncorrect");
			else
				iOrderRepository.delete(ordEntity);
			LOGGER.info("deleteOrder() service has executed");
			return ordEntity;
		}

		@Override
		public List<OrderEntity> getAllOrders(){
			List<OrderEntity> orderList = iOrderRepository.findAll();
			return orderList;
		}
		
		@Override
		public List<OrderEntity> getOrders(Long custId) {
			LOGGER.info("getCart() service is initiated");
			List<OrderEntity> ordEntity = iOrderRepository.findByCustId(custId);
			LOGGER.info("getcartdetails() has Executed");
			return ordEntity;
		}
		@Override
		public OrderEntity addOrder(Long custId) throws OrderNotFoundException{
			LOGGER.info("addOrder() service is initiated");
			CartEntity ct= new CartEntity();
			List<CartEntity> cartEntity = iCartRepository.findByCustId(ct.getCustId());
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
	        Date dateobj = new Date();
	        OrderEntity orderEntity = null;
	        OrderEntity oe=new OrderEntity();
	        for(CartEntity cart:cartEntity)
	        {
	          OrderEntity ordEntity = new OrderEntity( oe.getId(), oe.getAmount(), oe.getProductName(), oe.getBillingDate(), oe.getPaymentMethod(),oe.getCustId());
	        	orderEntity=iOrderRepository.save(ordEntity);
	        }
			/*if(order==null)
				order=null;
			else {*/
				
			LOGGER.info("addOrder() service has executed");
			return orderEntity;


		}
	}



