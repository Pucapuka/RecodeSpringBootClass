package com.spring_boot_initializer.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param;

import com.spring_boot_initializer.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT p FROM PRODUCT p WHERE p.name LIKE %:name%")
	List<Product> findByName(@Param("name") String name);
	
	@Query("SELECT p FROM PRODUCT p WHERE p.price <= :price")
	List<Product> findByPriceLowerThan(@Param("price") BigDecimal price);
}
