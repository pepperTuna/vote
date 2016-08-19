<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<title>설문조사 결과</title>
</head>
<body>
	<div class="container">
		<c:forEach items="${resultList}" var="ResultVO">
			${ResultVO.qno }번에  ${ResultVO.cno }번 대답함	<br/>
		</c:forEach>
	</div>
</body>
</html>