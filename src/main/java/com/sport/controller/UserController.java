package com.sport.controller;



	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.sport.entity.UserEntity;
import com.sport.exception.UserException;
import com.sport.service.IUserService;
	

	 
	@CrossOrigin(origins = "http://localhost:3000")
	@RestController
	@RequestMapping("/onlinesportshopee")
	public class UserController {
	    
	    static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	    
	    @Autowired
	    private IUserService iUserService;
	    
	    @PostMapping("/login/add-user")
	    public  ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user)throws UserException{
	        LOGGER.info("add-user URL is opened");
	        LOGGER.info("addUserEntity() is initiated");
	        UserEntity user2 = iUserService.signIn(user);
	        LOGGER.info("addUser() has executed");
	        return new ResponseEntity<UserEntity>(user2,HttpStatus.ACCEPTED);
	    }
	    
	    @GetMapping("/login/signin/{username}/{password}/{Role}")
	    public ResponseEntity<UserEntity> signIn(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("Role") String Role) throws UserException
	    {
	        LOGGER.info("signIn URL is opened");
	        LOGGER.info("signIn() is initiated");
	        UserEntity user1 = new UserEntity(password, username, Role);
	        UserEntity user = iUserService.signIn(user1);
	        LOGGER.info("signIn() has Executed");
	        return new ResponseEntity<UserEntity>(user,HttpStatus.ACCEPTED);
	    }
	    
	    
	    @GetMapping("/login/signout")
	    public ResponseEntity<String> signOut() throws UserException
	    {
	        LOGGER.info("sign-out URL is opened");
	        LOGGER.info("signout() is initiated");
	        String signout = iUserService.signOut(null); 
	        LOGGER.info("signout() has Executed");
	        return new ResponseEntity<String>(signout,HttpStatus.ACCEPTED);
	    }
	    
	    @PutMapping("/login/changepassword/{userId}")
	    public ResponseEntity<UserEntity> changePassword(@PathVariable Long userId, @RequestBody UserEntity User) throws UserException
	    {
	        LOGGER.info("changepassword URL is opened");
	        LOGGER.info("changepassword() is initiated");
	        UserEntity user = iUserService.changePassword(userId, User);
	        LOGGER.info("changepassword() has Executed");
	        return new ResponseEntity<UserEntity>(user,HttpStatus.ACCEPTED);
	    }    
	    
	}


