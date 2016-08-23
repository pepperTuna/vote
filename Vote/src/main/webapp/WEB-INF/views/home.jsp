<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<title>Home</title>
</head>
<body>
	<div class="container">
		<div class="starter-template">
			<h1>Hello world!</h1>
			<p class="lead">
				Ha !<br>
				The time on the server is ${serverTime}.
			</p>
			<a href="/listVote"><h1>설문 목록 보기</h1></a>
			<a href="/createVote"><h1>설문 작성하기</h1></a>
		</div>
	</div>
</body>
</html>
