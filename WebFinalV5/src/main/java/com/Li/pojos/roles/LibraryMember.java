package com.Li.pojos.roles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.Li.pojos.inventory.Event;
import com.Li.pojos.inventory.Inventory;

@Entity
@Table(name="libraryMember_table")
@PrimaryKeyJoinColumn(name = "userId")
public class LibraryMember extends User{


	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinTable(name = "libraryMember_Event", joinColumns = { @JoinColumn(name = "userId") }, 
			inverseJoinColumns = { @JoinColumn(name = "eventID") })
	private Set<Event> eventsRegistered = new HashSet<Event>(0);

	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinTable(name = "LibraryMember_Inventory", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "inventoryID") })
	 private Set<Inventory> borrowedInventory = new HashSet<Inventory>(0);
	 
	

	public LibraryMember(String username, String password, String role) {
		super(username, password, role);
		// TODO Auto-generated constructor stub
		
	}
	public LibraryMember(){
		 borrowedInventory = new HashSet<Inventory>(0);
	}

	public Set<Event> getEventsRegistered() {
		return eventsRegistered;
	}

	public void setEventsRegistered(Set<Event> eventsRegistered) {
		this.eventsRegistered = eventsRegistered;
	}

	public Set<Inventory> getBorrowedInventory() {
		return borrowedInventory;
	}

	public void setBorrowedInventory(Set<Inventory> borrowedInventory) {
		this.borrowedInventory = borrowedInventory;
	}
	 
	 
}
