package org.sunbeam.dmc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunbeam.dmc.dao.UserDao;
import org.sunbeam.dmc.dto.User;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserDao dao;

	@Transactional
	@Override
	public Integer register(User user) {
		
		return this.dao.register(user);
	}

	@Transactional
	@Override
	public User validate(String email, String password) {
		
		return this.dao.validate(email, password);
	}

}
