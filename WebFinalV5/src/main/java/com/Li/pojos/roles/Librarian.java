package com.Li.pojos.roles;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
@PrimaryKeyJoinColumn(name = "userId")
public class Librarian extends User{

	
	public Librarian(String username, String password, String role){
		
		super(username, password, role);
	}
}
