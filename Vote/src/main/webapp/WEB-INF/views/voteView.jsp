<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap.css"/>
	<title>앙 설문띠</title>
</head>
<body>
	<div class='container'>
		<div class='text-right'>
			<label>Survey Number: ${voteVO.vIdx}</label><br>
			<label>Writer: ${voteVO.vWriter}</label><br>
			<label>${voteVO.vUpdateDate}</label><br><br><br>
		</div>
		<h3>${voteVO.vTitle}</h3><br>
		<div class='col-md-6 .col-md-offset-3'>
			<c:forEach items ="${list}" var="voteQuestionVO">
				<dl>
					<!-- <th>${voteQuestionVO.vIdx}</th> -->
				<c:choose>
					<c:when test="${voteQuestionVO.cNo eq '0' }">
						<dt>${voteQuestionVO.qNo}. ${voteQuestionVO.content}</dt>
					</c:when>
					<c:otherwise>
						<dd><input type='radio' name='choice-${voteQuestionVO.vIdx}-${voteQuestionVO.qNo}-${voteQuestionVO.cNo}'>${voteQuestionVO.content}</dd>
						<dd>${voteQuestionVO.attach}</dd>
						<dd>${voteQuestionVO.attachType}</dd>
					</c:otherwise>
				</c:choose>
				</dl>
			</c:forEach>
			<!-- bootstrap.css line 1447 '0 -> 20' -->
		</div>
	</div>
</body>
</html>