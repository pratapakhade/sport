package com.sport.service;

	import java.util.List;
	import java.util.Optional;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.sport.entity.Admin;
import com.sport.entity.OrderEntity;
import com.sport.exception.AdminNotFoundException;
import com.sport.exception.CustomerNotFoundException;
import com.sport.repo.IAdminRepository;
import com.sport.repo.ICustomerRepository;
import com.sport.repo.IOrderRepository;

	

	@Service
	public class AdminServiceImpl implements IAdminService {

		@Autowired
		private IAdminRepository iadminRepository;

		@Autowired
		ICustomerRepository icustomerRepository;
		
		@Autowired
		IOrderRepository iorderRepository;
		
		
		Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);
		
		
		@Override
		public Admin insertAdmin(Admin admin) {
			logger.info("***********Inserting Admin Details*********************");
			
			return iadminRepository.save(admin);

		}

		
		@Override
		public Admin updateAdmin(Long id, Admin admin) throws AdminNotFoundException, Exception {
			
			logger.info("****Updating Admin Details********");
			
							
				if (id>0) {
					Optional<Admin> daoAdmin = iadminRepository.findById(id);

					if (daoAdmin.isPresent()) {
						Admin adminSave=daoAdmin.get();
						adminSave.setUsername(admin.getUsername());
						adminSave.setPassword(admin.getPassword());
						return iadminRepository.save(adminSave);
					}
					else {
						throw new AdminNotFoundException("Admin Not Found");
					}
				} else {
	                 throw new Exception("Please Provide A Valid Id To Update");
				}
		}

		
		
		@Override
		public Admin deleteAdmin(Long id) throws AdminNotFoundException, Exception {
			logger.info("****Deleting Admin Details********");
			
			
			if (id>0) {
				Optional<Admin> optional=iadminRepository.findById(id);
				if(optional.isPresent()) {
					Admin gotAdmin=optional.get();
					iadminRepository.delete(gotAdmin);
					return gotAdmin;
					
				}
				else {
					throw new AdminNotFoundException("Please Give proper id to delete");
				}

			} else {
	           throw new Exception("Please Provide A Valid Email Id");
			}
		}

		@Override
		public List<OrderEntity> getAllOrders(Long custId) throws CustomerNotFoundException {
			
	//LOGGER.info("***********Fetching List Of orders For Given CustId*********************");
	        
			if (custId <0) {
			throw new CustomerNotFoundException("Please Provide A valid customer Id");
		} else {
				return iorderRepository.findByCustId(custId);
			}

		}


		@Override
		public List<OrderEntity> getOrders(Long custId) throws CustomerNotFoundException {
			// TODO Auto-generated method stub
			if (custId <0) {
				throw new CustomerNotFoundException("Please Provide A valid customer Id");
			} else {
					return iorderRepository.findByCustId(custId);
			}
		}


	}
	


