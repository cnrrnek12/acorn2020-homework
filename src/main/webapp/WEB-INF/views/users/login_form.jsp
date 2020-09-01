<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/login_form</title>
</head>
<body>
<div class="container">
	<h1>로그인 페이지 입니다.</h1>
	<form action="login.do" method="post">
	<input type="hidden" name="url" value="${url }" />
		<div>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" />
		</div>
		<div>
			<label for="pwd">비밀번호</label>
			<input type="password" name="pwd" id="pwd" />
		</div>
		<button type="submit">로그인</button>
	</form>
	<a href="signup_form.do">회원가입 하러 가기</a>
</div>
</body>
</html>