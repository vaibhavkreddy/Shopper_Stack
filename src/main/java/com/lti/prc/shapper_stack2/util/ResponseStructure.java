package com.lti.prc.shapper_stack2.util;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.lti.prc.shapper_stack2.entity.Product;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private T data;
	private String message;
	private int statusCode;

}
