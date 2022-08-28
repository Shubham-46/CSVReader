package com.example.Controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Customer;
import com.example.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/savedata")
	public String setDatainDb() {
		cs.saveCustomerData();
		return "CSV File Added Successfully";
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Customer> getProductFromCatalogByIdHandler(@PathVariable("id") Integer id) {
		Customer prod =  cs.getCategoryWiseProducts(id);
		return new ResponseEntity<Customer>(prod, HttpStatus.FOUND);
	}
}
