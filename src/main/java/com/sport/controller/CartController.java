package com.sport.controller;


	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.sport.entity.CartEntity;
import com.sport.exception.CartException;
import com.sport.service.ICartService;

	

	 
	@CrossOrigin(origins = "http://localhost:3000")
	@RestController
	@RequestMapping("/onlinesportshopee")
	public class CartController {
	    
	    static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	    
	    @Autowired
	    private ICartService cartService;
	    
	    @PostMapping("/cart/addtocart/{custId}/{ProdID}")
	    public  ResponseEntity<CartEntity> addtocart(@PathVariable("custId") Long custId,@PathVariable("ProdID") Long ProdID) throws CartException{
	        LOGGER.info("add-cart URL is opened");
	        LOGGER.info("addtocart() is initiated");
	        CartEntity cartDTO = cartService.addCart(custId,ProdID);  
	        LOGGER.info("addtocart() has Executed");
	        return new ResponseEntity<CartEntity>(cartDTO, HttpStatus.ACCEPTED);
	    }
	    
	    @GetMapping("/cart/getCartDetails/{custId}")
		public List<CartEntity> getCartdetails(@PathVariable Long custId) throws CartException {
			LOGGER.info("getCartDetails URL is opened");
			LOGGER.info("getCart() has Executed");
		    return cartService.getCart(custId);
		}
	    
	    @DeleteMapping("/cart/removefromcart/{delID}")
	    public ResponseEntity<CartEntity> deletecart(@PathVariable long delID)throws CartException{
	        LOGGER.info("remove-cart URL is opened");
	        LOGGER.info("deletecart() is initiated");
	        CartEntity cartDTO = cartService.deleteCart(delID);
	        LOGGER.info("deletecart() has Executed");
	        return new ResponseEntity<CartEntity>(cartDTO, HttpStatus.ACCEPTED);
	    }
	    
	    @GetMapping("/cart/getallcartdetials")
	    public List<CartEntity> getAllProduct()
	    {
	        LOGGER.info("getall-cartdetails URL is opened");
	        LOGGER.info("getallcartdetails() initiated");
	        return cartService.getallCartDetails();
	    }
	}


