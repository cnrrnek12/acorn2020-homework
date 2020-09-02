package com.spring.jinho.users.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.spring.jinho.users.dto.UsersDto;

public interface UsersService {
	public void addUser(UsersDto dto);
	public void loginProcess(UsersDto dto, ModelAndView mView,
			HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mView);
	public void deleteUser(HttpSession session);
}
