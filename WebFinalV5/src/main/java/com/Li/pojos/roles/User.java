package com.Li.pojos.roles;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_table")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public class User{
	
	//mapping
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId", unique=true, nullable = false)
	int userId;
	
	@Column(name="userName")
	String userName;
	
	@Column(name="lastName")
	String lastName;
	
	@Column(name="firstName")
	String firstName;
	
	@Column(name="userRole")
	String userRole;
	
	@Column(name="userPassword")
	String userPassword;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	//@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "user")
	UEmail email;
	
	
	//constructor
	public User(String username, String password, String role) {
		this.userName = username;
		this.userPassword = password;
		this.userRole = role;
	}
	
	//default constructor
	public User(){}

	
	//getter&setter
	
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public UEmail getEmail() {
		return email;
	}


	public void setEmail(UEmail email) {
		this.email = email;
	}


	public int getUserId() {
		return userId;
	}


	@Override
	public String toString(){
		return userName;
		
	}
}
