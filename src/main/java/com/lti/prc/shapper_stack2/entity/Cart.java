package com.lti.prc.shapper_stack2.entity;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private String numberOfProducts;
	private double totalPrice;
	@CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
	private LocalDate creationDateTime;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cart")
	private List<Product> products;

}
