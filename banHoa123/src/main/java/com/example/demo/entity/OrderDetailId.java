package com.example.demo.entity;

import java.io.Serializable;

public class OrderDetailId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Order order;
	private Hoa hoa;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Hoa getHoa() {
		return hoa;
	}
	public void setHoa(Hoa hoa) {
		this.hoa = hoa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
