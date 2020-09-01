package com.spring.jinho.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jinho.users.dto.UsersDto;
import com.spring.jinho.users.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users/signup_form")
	public String signup_form() {
		
		return "users/signup_form";
	}
	
	//회원 가입 요청 처리
	@RequestMapping("/users/signup")
	public ModelAndView signup(UsersDto dto, ModelAndView mView) {
		//service 객체를 이용해서 사용자 정보를 추가 한다.
		usersService.addUser(dto);
		// view 페이지로 forward 이동해서 응답하기 
		mView.setViewName("/home");
		return mView;
	}
}
