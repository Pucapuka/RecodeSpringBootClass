package com.spring_boot_initializer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_boot_initializer.demo.model.Product;
import com.spring_boot_initializer.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping
	public String getAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String direction,
			Model model){
		
		Sort sort = direction.equalsIgnoreCase("desc")
				? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		Pageable pageable =  PageRequest.of(page, size, sort);
		
		Page<Product> productsPage = productRepo.findAll(pageable);
		
		model.addAttribute("products", productsPage);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("direction", direction);
		
		return "products";
	}
	 
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productRepo.deleteById(id);
	}
}
