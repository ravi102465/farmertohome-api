package com.rsg.framertohomeapi.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "customer_transaction")
@Data
public class CustomerTransaction {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private long transactionId;
	
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "purchased_on")
	private Timestamp purchasedOn;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id",insertable=false, updatable=false)
	private FarmerProduct products;

}
