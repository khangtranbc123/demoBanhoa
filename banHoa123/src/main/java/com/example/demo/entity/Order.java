package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_hoa")
public class Order {
	
	@Id
	@Column(name = "orderid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name = "createdate")
	private Date createDate;
	
	@Column(name = "customerid")
	private Integer customerId;
	
	@OneToMany(mappedBy = "orders")
	private List<OrderDetail> orderDetail;
	
	@Column
	private Integer role;
	
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	

	
	
}
