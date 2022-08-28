package com.example.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Customer;

@Repository
public interface CustomerDTO extends CrudRepository<Customer, Integer> {

	
	@Query("select new com.example.Repository.CustmoerDTO from Customer c where c.name=?1")
	public  Customer findByName(String name);
	

}
