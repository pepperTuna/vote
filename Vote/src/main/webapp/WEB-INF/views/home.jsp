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
				<a href="/listVote"><h1>설문 목록 보기</h1></a>
			</div>
		</div>
	</body>
</html>
