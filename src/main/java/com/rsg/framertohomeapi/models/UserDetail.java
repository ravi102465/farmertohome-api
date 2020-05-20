package com.rsg.framertohomeapi.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "users")
@Data
public class UserDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNo;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private int enabled;
	
	
	@Column(name = "timestamp")
	private Timestamp lastUpdated;
	
	@Column(name = "last_login")
	private Timestamp lastLogin;
	
	public UserDetail() {
		
	}
	
	@OneToMany
	@JoinTable(
			name = "roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleTypes> roles;
	
}
