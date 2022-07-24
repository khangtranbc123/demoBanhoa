package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {
	
	@Id 
	@Column(name = "orderDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer OrderDetailId;
	
	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order orders;
	
	
	@ManyToOne
	@JoinColumn(name = "hoaid")
	private Hoa hoas;
	
	@Column(name = "purchasedquantity")
	private Integer purchasedQuantity;
	@Column(name = "purchaedmoney")
	private BigDecimal purchaedMoney;
	
	
	
	
	public Order getOrders() {
		return orders;
	}
	public void setOrders(Order orders) {
		this.orders = orders;
	}
	public Hoa getHoas() {
		return hoas;
	}
	public void setHoas(Hoa hoas) {
		this.hoas = hoas;
	}
	public Integer getOrderDetailId() {
		return OrderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		OrderDetailId = orderDetailId;
	}
	
	public Integer getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(Integer purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	public BigDecimal getPurchaedMoney() {
		return purchaedMoney;
	}
	public void setPurchaedMoney(BigDecimal purchaedMoney) {
		this.purchaedMoney = purchaedMoney;
	}
	
	
}
