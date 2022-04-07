package org.sunbeam.dmc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.dmc.dto.User;

@Repository
public class UserDaoImplementation implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer register(User user)
	{
		
		Session session = this.sessionFactory.getCurrentSession();
		Integer userId = (Integer) session.save(user);
		return userId ;
	}

	@Override
	public User validate(String email, String password) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String hql = "FROM org.sunbeam.dmc.dto.User u WHERE u.email=:pEmail AND u.password=:pPassword";
		
		Query<User> query = session.createQuery(hql);
		query.setParameter("pEmail", email);
		query.setParameter("pPassword", password);
		
		return query.uniqueResult();
	}

}
