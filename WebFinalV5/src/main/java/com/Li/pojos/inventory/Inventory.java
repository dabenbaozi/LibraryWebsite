package com.Li.pojos.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.Li.pojos.roles.User;

@Entity
@Table(name="inventory_table")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
@FilterDef(name="availableFilter", parameters={
		@ParamDef( name="available", type="boolean" ),
})
@Filters( {
    @Filter(name="availableFilter", condition="isAvailable = true")
} )
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "inventoryID", unique=true, nullable = false)
	int inventoryID;
	
	@Column(name = "isAvailable")
    private boolean	isAvailable = true;
	
	@ManyToOne
	@JoinColumn(name = "userName")
    private User user;
	
	public Inventory(){
		
		
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public int getInventoryID() {
		return inventoryID;
	}



	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}


	public boolean isAvailable() {
		return isAvailable;
	}



	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
    
	 
	
}
