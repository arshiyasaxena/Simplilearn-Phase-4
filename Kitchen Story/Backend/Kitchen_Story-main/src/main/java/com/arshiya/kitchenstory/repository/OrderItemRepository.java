package com.arshiya.kitchenstory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arshiya.kitchenstory.model.OrderItem;
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
