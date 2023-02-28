package com.arshiya.kitchenstory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.kitchenstory.model.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
	public Cart findByUserUserid(long userid);
}
