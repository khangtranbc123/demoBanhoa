package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "hoa")
public class Hoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hoaid")
	private Integer id;
	@Column
	private String ten;
	@Column
	private String img;
	@Column
	private Integer soBong;
	@Column
	private Integer soLuong;
	@Column
	private BigDecimal gia;
	@Column
	private Date createDate;
	@Column
	private String hanSD;
	@Column
	private Integer trangThai;
	
	@ManyToOne
	@JoinColumn(name="chuDeHoa_id")
	private ChuDeHoas chuDeHoa;
	
	@OneToMany(mappedBy = "hoas")
	private List<OrderDetail> orderDetails;
	
	
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Hoa() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getSoBong() {
		return soBong;
	}

	public void setSoBong(Integer soBong) {
		this.soBong = soBong;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getHanSD() {
		return hanSD;
	}

	public void setHanSD(String hanSD) {
		this.hanSD = hanSD;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public ChuDeHoas getChuDeHoa() {
		return chuDeHoa;
	}

	public void setChuDeHoa(ChuDeHoas chuDeHoa) {
		this.chuDeHoa = chuDeHoa;
	}

	
	
	
}
