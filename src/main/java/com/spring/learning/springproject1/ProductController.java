package com.spring.learning.springproject1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learning.springproject1.dao.ProductRepo;

@RestController
public class ProductController {
	@Autowired
	private ProductRepo productRepo;
	
	
	@GetMapping("/Products")
	public Iterable<Product> getAllData(@RequestParam(value="search",required=false) String code){
		
		if(code==null){
			return productRepo.findAll();
		}
		else
		{
			code="%"+code+"%";
			return productRepo.findBySreach(code);
		}
		
		
		
	}
	@GetMapping("/Products/{id}")
	public Optional<Product> getDatabyId(@PathVariable int id){
		return productRepo.findById(id);
	}
	
}
