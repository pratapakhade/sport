package com.sport.service;

import java.util.List;

import com.sport.entity.AddressEntity;
import com.sport.exception.AddressNotFoundException;

public interface IAddressService {
		public AddressEntity addAddress(AddressEntity address) throws AddressNotFoundException;
		public AddressEntity removeAddress(Long custId) throws AddressNotFoundException;
		public AddressEntity updateAddress(Long custId,AddressEntity address) throws AddressNotFoundException;
		public List<AddressEntity> getAllAddress()throws AddressNotFoundException;

	}
	//


