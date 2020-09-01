<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<h1>인덱스 페이지 입니다.</h1>
	<a href="${pageContext.request.contextPath}/users/signup_form.do">회원가입 하러 가기</a>
	<a href="${pageContext.request.contextPath}/users/login_form.do">로그인 하러 가기</a>
</body>
</html>