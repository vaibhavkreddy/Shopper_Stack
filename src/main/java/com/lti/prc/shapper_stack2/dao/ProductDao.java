package com.lti.prc.shapper_stack2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.prc.shapper_stack2.entity.Product;
import com.lti.prc.shapper_stack2.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;
	public boolean isPresent;

	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> findById(int productId) {
		return productRepository.findById(productId);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void deleteProduct(int productId) {
		 productRepository.deleteById(productId);
	}
	
	public boolean isPresent(int productId) {
		return productRepository.existsById(productId);
	}
	
	public void updateProductPrice(int productId, double productPrice) {
		productRepository.updateProductPrice(productId,productPrice);
	}
	

}
