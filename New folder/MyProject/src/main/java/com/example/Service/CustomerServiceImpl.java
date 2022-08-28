package com.example.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Customer;
import com.example.Repository.CustomerDTO;
import com.example.Exception.ProductNotFoundException;


@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	private CustomerDTO cdto;
	
	@Override
    public void saveCustomerData()  {
    try {
    	BufferedReader br=new BufferedReader(new FileReader("src/main/resources/Book2.csv"));
    	br.readLine();		//ye sab  1st line ko skip karne ke liye likha hai 27 28 line number
    	String line=null;
    	while((line=br.readLine())!=null) {
    		String[] data=line.split(",");

    		System.out.println("Data ka length: "+data.length);
    		Customer c=new Customer();
    	//	for(String str: data) {
    			//System.out.println(str);
    		//	c.setId(data[0])
    			c.setCode(data[0]);
    			c.setName(data[1]);
        		c.setBatch(data[2]);
        		c.setStock(data[3]);
        		c.setDeal(data[4]);
        		c.setFree(data[5]);
        		c.setMrp(data[6]);
        		c.setRate(data[7]);
        		c.setExp(data[8]);
        		c.setSupplier(data[9]);
        		c.setCompany(data[10]);
        		
        		cdto.save(c);
    		//}
    		
    	}
  
    }catch (IOException e) {
		// TODO: handle exception
    	e.printStackTrace();
	}
    }

	@Override
	public Customer getCategoryWiseProducts(int id) {
		// TODO Auto-generated method stub
		Optional<Customer>	opt=cdto.findById(id);
		
		if (opt.isPresent()) {
			return opt.get();
		}
		else
			throw new ProductNotFoundException("Product not found with given id");

	}

	@Override
	public Customer getCategoryWiseProductsByName(String name) {
		// TODO Auto-generated method stub
		cdto.findByName(name);
		return null;
	}
    
}


