package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailId;

public interface IOrderDetailservice {
	void saveOrderDetail(OrderDetail orderDetail);
	List<OrderDetail> finByOrderId(Integer orderId);
	List<OrderDetail> getHoaDon(Integer customerId);
	List<OrderDetail> getAll();
}
