package bean;

import java.io.Serializable;
import java.sql.Date;

import dao.UserDao;
import pojo.User;

public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	

	
	private String full_name,email,password, message, birth_date;
	private UserDao dao;
	private User user;
	
	public UserBean() throws Exception 
	{	
		this.dao = new UserDao();
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String validate( ) throws Exception
	{
		this.user = this.dao.validate(this.email, this.password);
		if( this.user != null )
		{
			this.message = "Login is successful";
			return "UserDetails";
		}
		else
		{
			this.message = "Invalid email or password";
			return "Index";
		}
	}
	public String register( ) throws Exception
	{
		User user = new User(full_name, email, password, Date.valueOf(birth_date));
		int count = this.dao.registerUser(user);
		if( count != 0 )
		{
			this.message = "User is registered successfully.";
			return "Login";
		}
		else
		{
			this.message = "User creation failed";
			return "Index";
		}
	}
	
	
	


}
