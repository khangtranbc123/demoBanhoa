package com.example.demo.service;

import com.example.demo.entity.User;

public interface IUserService {
	public User finByEmail(String email);
	void dangky(User user);
}
