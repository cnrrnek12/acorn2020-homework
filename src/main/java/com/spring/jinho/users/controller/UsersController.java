package com.spring.jinho.users.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping("/users/login_form")
	public String loginform(HttpServletRequest request) {
		// url 파라미터가 넘어오는지 읽어와 보기 
		String url=request.getParameter("url");
		if(url==null){//목적지 정보가 없다면
			String cPath=request.getContextPath();
			url=cPath+"/home.do"; //로그인후 인덱스 페이지로 가도록 하기 위해 
		}
		//request 에 담는다. 
		request.setAttribute("url", url);
		return "users/login_form";
	}
	
	@RequestMapping("/users/login")
	public ModelAndView login(UsersDto dto, ModelAndView mView,
			HttpSession session, HttpServletRequest request) {
		//로그인후 가야하는 목적지 정보
		String url=request.getParameter("url");
		//목적지 정보도 미리 인코딩 해 놓는다.
		String encodedUrl=URLEncoder.encode(url);
		//view  페이지에 전달하기 위해 ModelAndView 객체에 담아준다. 
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		
		//service 객체를 이용해서 로그인 관련 처리를 한다.
		usersService.loginProcess(dto, mView, session);
		mView.setViewName("users/login");
		return mView;
	}
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
	
	//개인정보 보기 요청 처리
	@RequestMapping("/users/private/info")
	public ModelAndView info(HttpServletRequest request,ModelAndView mView) {
		usersService.getInfo(request.getSession(), mView);
		mView.setViewName("users/private/info");
		return mView;
	}
	@RequestMapping("/users/private/delete")
	public ModelAndView delete(HttpServletRequest request,
			ModelAndView mView) {
		//서비스를 이용해서 사용자 정보를 삭제하고
		usersService.deleteUser(request.getSession());
		//view 페이지로 forward 이동해서 응답
		mView.setViewName("users/private/delete");
		return mView;
	}
}
