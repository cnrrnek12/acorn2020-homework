<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form.jsp</title>
</head>
<body>
<div class="container">
	<h1>회원가입 페이지 입니다.</h1>
	<form action="signup.do" method="post">
		<div>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" placeholder="사용할 아이디 입력..." />
		</div>
		<div>
			<label for="pwd">비밀번호</label>
			<input type="password" name="pwd" id="pwd" />
		</div>
		<div>
			<label for="pwd2">비밀번호 확인</label>
			<input type="password" name="pwd2" id="pwd2" />
		</div>
		<div>
			<label for="email">이메일</label>
			<input type="text" name="email" id="email" placeholder="이메일 입력..." />		
		</div>
		<button type="submit">가입</button>
		<button type="reset">재 입력</button>
	</form>
</div>
</body>
</html>