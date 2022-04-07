package pojo;

import java.sql.Date;

import java.time.LocalDate;

public class User {
	
	private int id ;
	private String full_name,email,password;
	private Date birth_date,creation_date;
	
	@SuppressWarnings("deprecation")
	public User() 
	{	
		LocalDate ldt = LocalDate.now();
		this.creation_date = new Date( ldt.getYear() - 1900, ldt.getMonthValue() - 1, ldt.getDayOfMonth());
	}
	
	@SuppressWarnings("deprecation")
	public User(String full_name, String email, String password, Date birth_date ) 
	{
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.birth_date = birth_date;
		LocalDate ldt = LocalDate.now();
		this.creation_date = new Date( ldt.getYear() - 1900, ldt.getMonthValue() - 1, ldt.getDayOfMonth());
	}
	
	public User(String full_name, String email, String password, Date birth_date, Date creation_date) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.birth_date = birth_date;
		this.creation_date = creation_date;
	}

	public User(int id, String full_name, String email, String password, Date birth_date, Date creation_date) {
	
		this.id = id;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.birth_date = birth_date;
		this.creation_date = creation_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "id=" + id + ", full_name=" + full_name + ", email=" + email + ", password=" + password
				+ ", birth_date=" + birth_date + ", creation_date=" + creation_date ;
	}
	

}
