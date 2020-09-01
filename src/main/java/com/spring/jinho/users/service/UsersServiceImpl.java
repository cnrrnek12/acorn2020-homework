package com.spring.jinho.users.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jinho.users.dao.UsersDao;
import com.spring.jinho.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;

	@Override
	public void addUser(UsersDto dto) {
		//dto 객체에 비밀번호를 암호화 해서 넣어준다.
		String inputPwd=dto.getPwd(); //회원가입 form 에 입력한 비밀번호
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(inputPwd); //암호화된 비밀번호
		//암호화된 비밀번호를 dto 객체에 다시 넣어준다. 
		dto.setPwd(encodedPwd);
		
		//dao  객체를 이용해서 새로운 사용자 정보를 DB 에 저장하기 
		usersDao.insert(dto);
	}

	@Override
	public void loginProcess(UsersDto dto, ModelAndView mView, 
			HttpSession session) {
		//입력한 정보가 유효한 정보인지 여부를 저장할 지역변수 
		boolean isValid=false; //초기값 false
		//로그인폼에 입력한 아이디를 이용해서 DB 에서 select 해본다.
		//존재하지 않는 아이디면 null 이 리턴된다. 
		UsersDto resultDto=usersDao.getData(dto.getId());
		if(resultDto != null) {//아이디는 존재하는경우(아이디는 일치)
			//DB 에 저장된 암호화된 비밀번호 
			String encodedPwd=resultDto.getPwd();
			//로그인폼에 입력한 비밀번호 
			String inputPwd=dto.getPwd();
			//BCrypt 클래스의 static 메소드를 이용해서 일치 여부를 얻어낸다. 
			isValid=BCrypt.checkpw(inputPwd, encodedPwd);
		}
		
		if(isValid) {//만일 유효한 정보이면 
			//로그인 처리를 한다. 
			session.setAttribute("id", dto.getId());
			//view 페이지에서 사용할 정보 
			mView.addObject("isSuccess", true);
		}else {//아니면 
			mView.addObject("isSuccess", false);
		}
	}
}
