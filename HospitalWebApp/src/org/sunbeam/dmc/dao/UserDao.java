package org.sunbeam.dmc.dao;

import org.sunbeam.dmc.dto.User;

public interface UserDao {
	
	Integer register(User user);
	User validate(String email, String password); 

}
