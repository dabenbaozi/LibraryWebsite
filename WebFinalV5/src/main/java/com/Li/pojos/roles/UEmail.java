package com.Li.pojos.roles;

import javax.persistence.*;




@Entity
@Table(name = "email_detail")
//@PrimaryKeyJoinColumn(foreignKey = "emailId")
public class UEmail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "emailId", unique=true, nullable = false)
	private Integer emailId;
	
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="User_ID",referencedColumnName="userId",unique=true)
	//@OneToOne(optional = false, cascade = CascadeType.REFRESH)
    //@JoinColumn(name="User_ID",referencedColumnName="userId",unique=true)
	private User user;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	
	
 
	
	public Integer getEmailId() {
		return emailId;
	}




	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}




	public User getUser() {
		return this.user;
	}




	//@GenericGenerator(name = "generator", strategy = "foreign",parameters = @Parameter(name = "property", value = "user"))
	//@Id
	//@GeneratedValue(generator = "generator")
//	@JoinColumn(name = "User_ID", unique = true, nullable = false)
//	public Integer getUserId() {
//		return userId;
//	}



//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//



	public String getEmailAddress() {
		return emailAddress;
	}




	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}




	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString(){
		return emailAddress;
		
		
	}
	
	
}
