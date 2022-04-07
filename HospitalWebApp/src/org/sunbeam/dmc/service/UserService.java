package org.sunbeam.dmc.service;

import org.sunbeam.dmc.dto.User;

public interface UserService {

	Integer register( User user );
	User validate( String email, String password );
}
