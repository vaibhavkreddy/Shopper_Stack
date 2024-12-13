package com.lti.prc.shapper_stack2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lti.prc.shapper_stack2.dao.ProductDao;
import com.lti.prc.shapper_stack2.entity.Cart;
import com.lti.prc.shapper_stack2.entity.Product;
import com.lti.prc.shapper_stack2.util.ResponseStructure;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product saveProduct = productDao.saveProduct(product);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setData(saveProduct);
		structure.setMessage("product saved sucessfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
		Optional<Product> byId = productDao.findById(productId);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		if(byId.isPresent()) {
			structure.setData(byId.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		List<Product> all = productDao.findAll();
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		structure.setData(all);
		structure.setMessage("Products Founds");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int productId) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(productDao.isPresent(productId)) {
			productDao.deleteProduct(productId);
			structure.setData("Product deleted successfully.");
			structure.setMessage("Product deletion successful.");
			structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<>(structure, HttpStatus.OK);
		}
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	}


	
	

}
