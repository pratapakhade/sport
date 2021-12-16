package com.test.product;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sport.entity.UserEntity;
import com.sport.repo.IUserRepository;
import com.sport.service.IUserService;


@SpringBootTest
class UserServiceImplTest {

	@MockBean
	IUserRepository iuserdao;
	
	
	@Autowired
	IUserService iuserservice;
	
	UserEntity user=null;
	
	@Test
	void testAddUser01() throws Exception
	{
		user = new UserEntity();
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		Mockito.when(iuserdao.saveAndFlush(user)).thenReturn(user);
		assertNotNull(user);
	}
	
	@Test
    void testSignInUser01() throws Exception
    {
        user = new UserEntity();
        user.setId((long)1);
        user.setPassword("chakri@123");
       
        Mockito.when(iuserdao.save(user)).thenReturn(user);
        assertNotNull(user);
    }
	
	@Test
	void testChangePassword01() throws Exception
	{
		user = new UserEntity();
		user.setId((long)8);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		user.setPassword("chakri@456");
		Mockito.when(iuserdao.save(user)).thenReturn(user);
	}
}
