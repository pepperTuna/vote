<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form role="form" method="post">
		<input type='hidden' name='vIdx' value="${voteVO.vIdx}">
	</form>
	<label>${voteVO.vIdx}</label><Br>
	<label>${voteVO.vWriter}</label><br>
	<label>${voteVO.vTitle}</label><br>
	<label>${voteVO.vUpdateDate}</label><br>
	
	<table class="table table=bordered">
	
	<c:forEach items ="${list}" var="voteQuestionVO">
	
		<tr>
			<th>${voteQuestionVO.vIdx}</th>
			<th>${voteQuestionVO.qNo}</th>
			<th>${voteQuestionVO.cNo}</th>
			<th>${voteQuestionVO.content}</th>
			<th>${voteQuestionVO.attach}</th>
			<th>${voteQuestionVO.attachType}</th>
		</tr>
		
	</c:forEach>
		
	</table>
</body>
</html>