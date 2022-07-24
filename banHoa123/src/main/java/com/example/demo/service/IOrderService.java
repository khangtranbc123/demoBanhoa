package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hoa;
import com.example.demo.entity.Order;

public interface IOrderService {
	void saveOrder(Order order);
	List<Order> finByUser(Integer customerId);
	public Order finByUser2(Integer customerId);
	public Order finById(int orderId);

}
