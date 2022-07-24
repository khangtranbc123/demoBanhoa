package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository iUserRepository;
	
	@Override
	public User finByEmail(String email) {
		
		return iUserRepository.findByEmail(email);
	}

	@Override
	public void dangky(User user) {
		iUserRepository.save(user);
	}

	

}
