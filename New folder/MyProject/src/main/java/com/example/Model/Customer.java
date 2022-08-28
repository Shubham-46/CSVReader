package com.example.Model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String code;
	private String name;
	private String batch;
	private String stock;
	private String deal;
	private String free;
	private String mrp;
	private String rate;
	private String exp;
	private String supplier;
	private String company;
	
	
	
	
	
}
