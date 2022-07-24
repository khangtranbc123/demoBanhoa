package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderDetailId;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{
	List<OrderDetail> findByOrders(Integer orderId);
	
	@Query("SELECT DISTINCT a FROM OrderDetail a JOIN a.orders b WHERE b.customerId = ?1")
	List<OrderDetail> findByHoaDon(Integer customerId);


}
