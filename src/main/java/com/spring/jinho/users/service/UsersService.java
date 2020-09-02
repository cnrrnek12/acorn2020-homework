package com.spring.jinho.users.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jinho.users.dto.UsersDto;

public interface UsersService {
	public void addUser(UsersDto dto);
	public void loginProcess(UsersDto dto, ModelAndView mView,
			HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mView);
	public void deleteUser(HttpSession session);
	public Map<String, Object> saveProfileImage(HttpServletRequest request,
			MultipartFile mFile);
	public void updateUser(HttpSession session, UsersDto dto);
	public void updateUserPwd(HttpSession session, UsersDto dto,
			ModelAndView mView);
}
