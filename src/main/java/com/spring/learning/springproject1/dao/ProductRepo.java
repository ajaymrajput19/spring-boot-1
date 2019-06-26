package com.spring.learning.springproject1.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.spring.learning.springproject1.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {

	@Query("from Product where code like ?1")
	List<Product> findBySreach(String code);

	/*Iterable<Product> findBySearch();*/

}
