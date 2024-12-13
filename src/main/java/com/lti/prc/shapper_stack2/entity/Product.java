package com.lti.prc.shapper_stack2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String productName;
	private String productFeature;
	@Column(nullable = false)
	private double productPrice;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Cart cart;
}
