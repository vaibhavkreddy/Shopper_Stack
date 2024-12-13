package com.lti.prc.shapper_stack2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.lti.prc.shapper_stack2.entity.Product;
import com.lti.prc.shapper_stack2.service.ProductService;
import com.lti.prc.shapper_stack2.util.ResponseStructure;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Product>> saveproduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}
	@GetMapping("/productId")
	public ResponseEntity<ResponseStructure<Product>> findById(@RequestParam int productId){
		return productService.findById(productId);
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
		return productService.findAll();
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@RequestParam int productId){
		return productService.deleteProduct(productId);
	}

}
