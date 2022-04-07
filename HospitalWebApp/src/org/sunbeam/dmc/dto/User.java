package org.sunbeam.dmc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "users1" )
public class User {
	
	private int id;
	private String fullName;
	private String email;
	private String password;
	private Date birthDate;
	
	public User() {     }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column
	public Date getBirthDate() {
		
		return birthDate;
		
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", birthDate=" + birthDate + "]";
	}
	

}
