package com.sport.controller;



	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.sport.entity.OrderEntity;
import com.sport.exception.InvalidOrderIdException;
import com.sport.exception.OrderNotFoundException;
import com.sport.service.IOrderService;



	 
	@CrossOrigin(origins = "http://localhost:3000")
	@RestController
	@RequestMapping("/onlinesportshopee")
	public class OrderController {

	    static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	    //
	    @Autowired
	    private IOrderService iOrderService;
	    
	    @PostMapping("/add-order/{custID}")
	    public  ResponseEntity<OrderEntity> addOrder(@PathVariable Long custID, @RequestBody OrderEntity order)throws OrderNotFoundException,InvalidOrderIdException{
	        LOGGER.info("add-order URL is opened");
	        LOGGER.info("addOrderEntity() is initiated");
	        OrderEntity orderDTO = iOrderService.addOrder(custID);
	        LOGGER.info("addOrder() has executed");
	        return new ResponseEntity<OrderEntity>(orderDTO, HttpStatus.ACCEPTED);
	    }

	    @PutMapping("/update-order/{orderID}")
	    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long orderID, @RequestBody OrderEntity order)throws OrderNotFoundException, InvalidOrderIdException{
	        LOGGER.info("update-order URL is opened");
	        LOGGER.info("updateOrderEntity() is initiated");
	        OrderEntity orderDTO = iOrderService.updateOrder(orderID,order);
	        LOGGER.info("updateOrder() has executed");//jh
	        return new ResponseEntity<OrderEntity>(orderDTO, HttpStatus.ACCEPTED);
	    }

	    @DeleteMapping("/remove-order/{orderID}")
	    public ResponseEntity<OrderEntity> deleteOrder(@PathVariable long orderID)throws OrderNotFoundException, InvalidOrderIdException{
	        LOGGER.info("delete-order URL is opened");
	        LOGGER.info("deleteOrderEntity() is initiated");
	        OrderEntity orderDTO=iOrderService.removeOrder(orderID);
	        LOGGER.info("deleteOrderEntity() has executed");
	        return new ResponseEntity<OrderEntity>(orderDTO, HttpStatus.ACCEPTED);
	    }

	    @GetMapping("/get-all-order")
	    public List<OrderEntity> getAllOrder(){
	    
	        LOGGER.info("getallorders URL is opened");
	        LOGGER.info("getAllOrder() is initiated");
	        LOGGER.info("getAllOrder() has executed");
	        return iOrderService.getAllOrders();
	     }
	    
	    @GetMapping("/getOrder/{custId}")
		public List<OrderEntity> getCartdetails(@PathVariable Long custId) throws InvalidOrderIdException {
	    	LOGGER.info("getById URL is opened");
	        LOGGER.info("getById() is initiated");
	        LOGGER.info("getOrderById() has executed");
		    return iOrderService.getOrders(custId);
		}
	    
	}


