package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ChuDeHoas;
import com.example.demo.entity.Hoa;



public interface IHoaService {

	Page<Hoa> getByPage(int pageNumber, int maxRecoed);
	void saveHoa(Hoa hoa);
	void deleteHoa(Integer id);
	Optional<Hoa> findHoaById(Integer id);
	Page<Hoa> finHoaTheoChuDe(String tenChuDeHoa, int pageNumber, int maxRecoed);
	public Hoa finById(int id);
	Page<Hoa> finHoaByTen(String ten, int pageNumber, int maxRecoed);
	List<Hoa> getAll();

}
