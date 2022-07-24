package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hoa;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailId;
import com.example.demo.repository.IOrderDetailRepository;
import com.example.demo.service.IOrderDetailservice;

@Service
public class OrderDetailImpl implements IOrderDetailservice{

	@Autowired private IOrderDetailRepository iOrderDetailRepository;

	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		iOrderDetailRepository.save(orderDetail);
		
	}

	@Override
	public List<OrderDetail> finByOrderId(Integer orderId) {
		return iOrderDetailRepository.findByOrders(orderId);
	}

	@Override
	public List<OrderDetail> getHoaDon(Integer customerId) {
		// TODO Auto-generated method stub
		return iOrderDetailRepository.findByHoaDon(customerId);
	}

	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		return iOrderDetailRepository.findAll();
	}


	
	
	
}
