package com.sport.service;

import com.sport.entity.UserEntity;
import com.sport.exception.UserException;


public interface IUserService {

		public UserEntity addUser(UserEntity user) throws UserException;
		public UserEntity signIn(UserEntity user) throws UserException;
		public String signOut(UserEntity user);
		public UserEntity changePassword(Long id,UserEntity user) throws UserException;
		

	}



