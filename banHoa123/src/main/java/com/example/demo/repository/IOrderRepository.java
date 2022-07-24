package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findByCustomerIdLike(Integer customerId);
	public Order findByCustomerId(Integer customerId);

}
