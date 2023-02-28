package com.arshiya.kitchenstory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.kitchenstory.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findByProductname(String name);
}
