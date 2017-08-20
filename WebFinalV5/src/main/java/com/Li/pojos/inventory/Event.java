package com.Li.pojos.inventory;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Li.pojos.roles.User;

@Entity
@Table(name="event_table")
@PrimaryKeyJoinColumn(name = "inventoryID")
@FilterDef(name="notExpriedFilter", parameters={
		@ParamDef( name="isExpried", type="boolean" ),
})
@Filters( {
    @Filter(name="notExpriedFilter", condition="isExpried = false")
} )
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eventID", unique=true, nullable = false)
	int	eventID;
	
	/*@Column(name = "startDate")
	@Type(type="date")
	Date	startDate;
	
	@Column(name = "endDate")
	@Type(type="date")
	Date	endDate;
	*/
	@Column(name = "isExpried")
	@Type(type="boolean")
	boolean	isExpried = false;
	
	@Column(name = "description")
	String	description;
	
	@Transient
	CommonsMultipartFile	poster;//image location
	
	@Column(name = "location")
	String	location;
	
	@ManyToMany(fetch = FetchType.LAZY)
	Set<User>	registeredUsers = new HashSet<User>();//userList

	
	@Column(name = "filename")
	private String filename;
	
	
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
/*
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}*/

	public boolean isExpried() {
		return isExpried;
	}

	public void setExpried(boolean isExpried) {
		this.isExpried = isExpried;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommonsMultipartFile getPoster() {
		return poster;
	}

	public void setPoster(CommonsMultipartFile poster) {
		this.poster = poster;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public Set<User> getRegisteredUsers() {
		return registeredUsers;
	}

	
	public void setRegisteredUsers(Set<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}
