package com.sport.controller;

	import java.util.List;

	import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

import com.sport.entity.Admin;
import com.sport.entity.OrderEntity;
import com.sport.exception.AdminNotFoundException;
import com.sport.exception.CustomerNotFoundException;
import com.sport.service.IAdminService;

	
	@CrossOrigin(origins="http://localhost:3000")
	@RestController
	@RequestMapping("/onlinesportshopee")
	public class AdminController {

		@Autowired
		IAdminService adminService;
		

		@PostMapping("/admin/insert")
		public ResponseEntity<Admin> insertAdmin(@Valid @RequestBody Admin admin) {
			Admin serviceAdmin = adminService.insertAdmin(admin);
			return new ResponseEntity<Admin>(serviceAdmin, HttpStatus.CREATED);
		}

		@PutMapping("/admin/update/{id}")
		public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,@Valid @RequestBody Admin admin) throws AdminNotFoundException, Exception {
			
			Admin serviceAdmin = adminService.updateAdmin(id,admin);
			return new ResponseEntity<>(serviceAdmin, HttpStatus.OK);
		}

		@DeleteMapping("/admin/delete/{id}")
		public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id) throws AdminNotFoundException, Exception {
			
			Admin serviceAdmin = adminService.deleteAdmin(id);
			return new ResponseEntity<Admin>(serviceAdmin, HttpStatus.OK);
		}

		@GetMapping("admin/customer/getOrder")
		public ResponseEntity<List<OrderEntity>> getOrders(@RequestParam("id") Long custId) throws CustomerNotFoundException {
			List<OrderEntity> serviceGetOrder = adminService.getOrders(custId);
			return new ResponseEntity<List<OrderEntity>>(serviceGetOrder, HttpStatus.OK);
		}

		@GetMapping("admin/customer/getAllOrders")
		public ResponseEntity<List<OrderEntity>> getAllOrders(@RequestParam("id") Long custId) throws CustomerNotFoundException {
			List<OrderEntity> serviceAdmin = adminService.getAllOrders(custId);
			return new ResponseEntity<List<OrderEntity>>(serviceAdmin, HttpStatus.OK);
		}

	}




//
//package com.sport.controller;
//
//
//
//	import org.slf4j.Logger;
//	import org.slf4j.LoggerFactory;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.http.HttpStatus;
//	import org.springframework.http.ResponseEntity;
//	import org.springframework.web.bind.annotation.*;
//
//import com.sport.entity.UserEntity;
//import com.sport.exception.UserException;
//import com.sport.service.IUserService;
//	
//
//	 
//	@CrossOrigin(origins = "http://localhost:3000")
//	@RestController
//	@RequestMapping("/onlinesportshopee")
//	public class AdminController {
//	    
//	    static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
//	    
//	    @Autowired
//	    private IAdminService iadminService;
//	    
//	    @PostMapping("/login/add-admin")
//	    public  ResponseEntity<Admin> addUser(@RequestBody Admin admin)throws UserException{
//	        LOGGER.info("add-user URL is opened");
//	        LOGGER.info("addUserEntity() is initiated");
//	        UserEntity admin = iadminService.addAdmin(admin);
//	        LOGGER.info("addUser() has executed");
//	        return new ResponseEntity<Admin>(admin,HttpStatus.ACCEPTED);
//	    }
//	    
//	    @DeleteMapping("/admin/delete/{id}")
//		public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id) throws AdminNotFoundException, Exception {
//			
//			Admin serviceAdmin = iadminService.deleteAdmin(id);
//			return new ResponseEntity<Admin>(serviceAdmin, HttpStatus.OK);
//		}
//	    
//	    @GetMapping("/login/signin/{username}/{password}")
//	    public ResponseEntity<Admin> signIn(@PathVariable("username") String username,@PathVariable("password") String password) throws UserException
//	    {
//	        LOGGER.info("signIn URL is opened");
//	        LOGGER.info("signIn() is initiated");
//	        UserEntity admin1 = new UserEntity(password, username);
//	        UserEntity admin = iadminService.signIn(admin1);
//	        LOGGER.info("signIn() has Executed");
//	        return new ResponseEntity<UserEntity>(admin,HttpStatus.ACCEPTED);
//	    }
//	    
//	    
//	    @GetMapping("/login/signout")
//	    public ResponseEntity<String> signOut() throws UserException
//	    {
//	        LOGGER.info("sign-out URL is opened");
//	        LOGGER.info("signout() is initiated");
//	        String signout = iadminService.signOut(null); 
//	        LOGGER.info("signout() has Executed");
//	        return new ResponseEntity<String>(signout,HttpStatus.ACCEPTED);
//	    }
//	    
//	    @PutMapping("/login/changepassword/{userId}")
//	    public ResponseEntity<Admin> changePassword(@PathVariable Long userId, @RequestBody UserEntity User) throws UserException
//	    {
//	        LOGGER.info("changepassword URL is opened");
//	        LOGGER.info("changepassword() is initiated");
//	        UserEntity user = iadminService.changePassword(userId, User);
//	        LOGGER.info("changepassword() has Executed");
//	        return new ResponseEntity<UserEntity>(user,HttpStatus.ACCEPTED);
//	    }    
//	    
//	}
//
//



