package com.example.demo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chudehoas")
public class ChuDeHoas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String tenChuDeHoa;
	
	@OneToMany(mappedBy = "chuDeHoa")
	private List<Hoa> hoa;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTenChuDeHoa() {
		return tenChuDeHoa;
	}
	public void setTenChuDeHoa(String tenChuDeHoa) {
		this.tenChuDeHoa = tenChuDeHoa;
	}
	public List<Hoa> getHoa() {
		return hoa;
	}
	public void setHoa(List<Hoa> hoa) {
		this.hoa = hoa;
	}
	

	
}
