package com.sport.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.entity.AddressEntity;
import com.sport.exception.AddressNotFoundException;
import com.sport.repo.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Autowired
	private IAddressRepository iaddressRepository;
	
	@Override
	public AddressEntity addAddress(AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress() service is initiated");
		AddressEntity addressentity;
		if(address == null)
			addressentity = null;
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("addAddress() service has executed");
		return addressentity;
	}

	@Override
	public AddressEntity removeAddress(Long custId) throws AddressNotFoundException {
		LOGGER.info("removeAddress() service is initiated");
		AddressEntity existaddress = iaddressRepository.findById(custId).orElse(null);
		if(existaddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		else {
			iaddressRepository.delete(existaddress);
		}
		LOGGER.info("removeAddress() service has executed");
		return existaddress;
	}

	@Override
	public AddressEntity updateAddress(Long custId, AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("updateAddress() service is initiated");
		AddressEntity addressentity = null;
		AddressEntity updateaddress = iaddressRepository.findById(custId).orElse(null);
		if(updateaddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("updateAddress() service has executed");
		return addressentity;
	}

	@Override
	public List<AddressEntity> getAllAddress()throws AddressNotFoundException {
		LOGGER.info("getAddress() service is initiated");
		List<AddressEntity> getAddress = iaddressRepository.findAll();;
		if(getAddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		LOGGER.info("getAddress() service has executed");
		return getAddress;
	}

}
