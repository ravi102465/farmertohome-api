package com.rsg.framertohomeapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "role_types")
@Data
public class RoleTypes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long roleId;
	
	@Column(name = "role_type")
	private String roleType;
	
	@Column(name = "role_description")
	private String roleDescription;

	public RoleTypes() {
	}
	
	
	
}
