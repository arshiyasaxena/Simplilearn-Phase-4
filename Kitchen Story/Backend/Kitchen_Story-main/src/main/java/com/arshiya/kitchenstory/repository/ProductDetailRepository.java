package com.arshiya.kitchenstory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.kitchenstory.model.ProductDetail;
@Repository
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
	public ProductDetail findByProductProductid(long productid);
}
