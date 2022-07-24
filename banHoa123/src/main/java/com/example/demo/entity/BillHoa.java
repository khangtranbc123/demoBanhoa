package com.example.demo.entity;

import java.math.BigDecimal;

public class BillHoa {
	private int hoaId;
	private BigDecimal gia;
	private Hoa hoa;
	private int soLuong;
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	public Hoa getHoa() {
		return hoa;
	}
	public void setHoa(Hoa hoa) {
		this.hoa = hoa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getHoaId() {
		return hoaId;
	}
	public void setHoaId(int hoaId) {
		this.hoaId = hoaId;
	}
	
}
