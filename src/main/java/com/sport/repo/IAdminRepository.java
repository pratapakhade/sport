package com.sport.repo;

	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.sport.entity.Admin;



	@Repository
	public interface IAdminRepository extends JpaRepository<Admin,Long>{

		//Admin findById(int adminId);

		//Admin deleteById(int adminId);
		
	}


//package com.sport.repo;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.sport.entity.Admin;
//import com.sport.entity.UserEntity;
//	@Repository
//	public interface IAdminRepository extends JpaRepository<Admin, Long> {
//		@Query(value = "SELECT * FROM users u WHERE u.username = ?1",nativeQuery = true)
//		Admin findByUserName(Long username);
//
//	}


