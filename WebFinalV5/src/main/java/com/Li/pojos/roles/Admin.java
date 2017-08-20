package com.Li.pojos.roles;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin_table")
@PrimaryKeyJoinColumn(name = "userId")
//admin-singleton
public class Admin extends User{
	

	private Admin(String username, String password, String role) {
		super("Admin", "Admin", "Admin");
	
	}

	public static Admin getInstance() {
	      if(admin == null) {
	         admin = new Admin("Admin", "Admin", "Admin");
	         admin.userId = 1;
	      }
	      return admin;
	   }
	private static Admin admin;


	 
}
