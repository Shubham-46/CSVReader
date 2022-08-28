package com.example.Service;

import java.util.List;

import com.example.Model.Customer;
import com.example.Repository.CustomerDTO;



public interface CustomerService {
	
	public void saveCustomerData();
	
	public Customer getCategoryWiseProducts(int id);
	
	public Customer getCategoryWiseProductsByName(String name);
	
	
	
}
