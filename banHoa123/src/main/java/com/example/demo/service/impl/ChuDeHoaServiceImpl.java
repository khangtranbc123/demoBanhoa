package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ChuDeHoas;
import com.example.demo.repository.IChuDeHoaRepository;
import com.example.demo.service.IChuDeHoaService;

@Service
public class ChuDeHoaServiceImpl implements IChuDeHoaService{
	@Autowired
	IChuDeHoaRepository chuDeHoaService;

	@Override
	public List<ChuDeHoas> getAll() {
		return chuDeHoaService.findAll();
	}
	
	
}
