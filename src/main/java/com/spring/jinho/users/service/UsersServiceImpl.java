package com.spring.jinho.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.jinho.users.dao.UsersDao;
import com.spring.jinho.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;

	@Override
	public void addUser(UsersDto dto) {
		//dao  객체를 이용해서 새로운 사용자 정보를 DB 에 저장하기 
		usersDao.insert(dto);
	}
}
