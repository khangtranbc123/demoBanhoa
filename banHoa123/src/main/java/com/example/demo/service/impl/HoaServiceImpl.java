package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ChuDeHoas;
import com.example.demo.entity.Hoa;
import com.example.demo.repository.IHoaRepository;
import com.example.demo.service.IHoaService;

@Service
public class HoaServiceImpl implements IHoaService{
	@Autowired
	private IHoaRepository ihoaRepository;
	
	@Override
	public Page<Hoa> getByPage(int pageNumber, int maxRecord){
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<Hoa> page = ihoaRepository.findAll(pageable);
		return page;
	}
	
	
	@Override
	public Page<Hoa> finHoaTheoChuDe(String tenChuDeHoa, int pageNumber, int maxRecoed) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecoed);
		Page<Hoa> page = ihoaRepository.findByChuDeHoaLike1(tenChuDeHoa, pageable);
		return page;
	}
	
	@Override
	public Page<Hoa> finHoaByTen(String ten, int pageNumber, int maxRecoed) {
		Pageable pageable = PageRequest.of(pageNumber, maxRecoed);
		Page<Hoa> page = ihoaRepository.findByTenLike(ten, pageable);

		return page;
	}
//	@Override
//	public Page<Hoa> findHoaByType(HoaType type,int pageNumber, int maxRecord) {
//		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
//		Page<Hoa> page = ihoaRepository.findByTypeLike(type, pageable);
//		return page;
//	}
	
	@Override
	public void saveHoa(Hoa hoa) {
	 ihoaRepository.save(hoa);
	}

	@Override
	public void deleteHoa(Integer id) {
		ihoaRepository.deleteById(id);
	}

	@Override
	public Optional<Hoa> findHoaById(Integer id) {	
		return ihoaRepository.findById(id);
	}


	@Override
	public Hoa finById(int id) {

		return ihoaRepository.getById(id);
	}


	@Override
	public List<Hoa> getAll() {
		
		return ihoaRepository.findAll();
	}


	


	


	

	

	
	


	
	
	
	
}
