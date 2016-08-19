<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home</title>
		<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="starter-template">
				<h1>Hello world!</h1>
				<p class="lead">
					Ha !<br>
					The time on the server is ${serverTime}.<br>
					This page is an example.
				</p>
				<a href="/vote/listVote"><h1>설문 목록 보기</h1></a>
				<a href="/vote/createVote"><h1>설문 작성하기</h1></a>
			</div>
		</div>
	</body>
</html>
