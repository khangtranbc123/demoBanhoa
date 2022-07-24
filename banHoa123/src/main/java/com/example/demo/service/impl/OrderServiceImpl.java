package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hoa;
import com.example.demo.entity.Order;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired private IOrderRepository iOrderRepository;
	
	@Override
	public void saveOrder(Order order) {
		iOrderRepository.save(order);
	}

	@Override
	public List<Order> finByUser(Integer customerId) {
		
		return iOrderRepository.findByCustomerIdLike(customerId);
	}

	@Override
	public Order finByUser2(Integer customerId) {
		// TODO Auto-generated method stub
		return iOrderRepository.findByCustomerId(customerId);
	}

	@Override
	public Order finById(int orderId) {
		
		return iOrderRepository.getById(orderId);
	}

	
	
}
