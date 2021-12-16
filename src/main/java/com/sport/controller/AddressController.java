package com.sport.controller;


	import java.util.List;

	import org.slf4j.Logger;

import com.sport.service.*;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.sport.entity.AddressEntity;
import com.sport.exception.AddressNotFoundException;


	@RestController
	@RequestMapping("/onlinesportshopee")

	public class AddressController {
		
		@Autowired
		private AddressServiceImpl AddressServiceImpl;
		
		static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
		
		

		@PostMapping("/address/addAddress")
		public ResponseEntity<AddressEntity> addAddress(@RequestBody AddressEntity address) throws AddressNotFoundException {
			LOGGER.info("addAddress URL is opened");
			LOGGER.info("addAddress() is initiated");
			AddressEntity addressDTO = null;
			ResponseEntity<AddressEntity> addressResponse = null;
			addressDTO = AddressServiceImpl.addAddress(address);
			addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
			LOGGER.info("addAddress() has executed");
			return addressResponse;
		}

		@DeleteMapping("/address/removeAddress/Address/{custId}")
		public ResponseEntity<AddressEntity> removeAddress(@PathVariable long custId) throws AddressNotFoundException {
			LOGGER.info("removeAddress URL is opened");
			LOGGER.info("removeAddress() is initiated");
			AddressEntity addressDTO = null;
			ResponseEntity<AddressEntity> addressResponse = null;
			addressDTO = AddressServiceImpl.removeAddress(custId);
			addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
			LOGGER.info("removeAddress() has executed");
			return addressResponse;
		}

		@PutMapping("/address/updateAddress/{custId}")
		public ResponseEntity<AddressEntity> updateAddress(@PathVariable long custId,@RequestBody AddressEntity address) throws AddressNotFoundException {
			LOGGER.info("updateAddress URL is opened");
			LOGGER.info("updateAddress() is initiated");
			AddressEntity addressDTO = null;
			ResponseEntity<AddressEntity> addressResponse = null;
			addressDTO = AddressServiceImpl.updateAddress(custId,address);
			addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
			LOGGER.info("updateAddress() has executed");
			return addressResponse;
		}

		@GetMapping("/address/getAddressDetails")
		public ResponseEntity<AddressEntity> getAddress() throws AddressNotFoundException {
			LOGGER.info("getAddressDetails URL is opened");
			LOGGER.info("getAddress() is initiated");
			List<AddressEntity> addressDTO = null;
			ResponseEntity<AddressEntity> addressResponse = null;
			addressDTO = AddressServiceImpl.getAllAddress();
			addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
			LOGGER.info("getAddress() has executed");
			return addressResponse;
		}
		
		//

	}



