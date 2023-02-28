package com.arshiya.kitchenstory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.kitchenstory.model.CartItem;
@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
	public List<CartItem> findCartItemByCartCartid(long cartid);
	public CartItem findCartItemByProductProductid(long productid);
}
