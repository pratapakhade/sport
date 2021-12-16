package com.sport.validation;

import com.sport.entity.UserEntity;
import com.sport.exception.UserException;

public class UserValidationImpl {
		
		public static UserEntity validateUser(UserEntity user) throws UserException {
				if(user.getUsername() != null)
				{
					if(user.getPassword() != null)
					{
						return user;
					}
					else throw new UserException("Password cannot be empty");
				}
				else throw new UserException("Username cannot be empty");
		}	
	}



