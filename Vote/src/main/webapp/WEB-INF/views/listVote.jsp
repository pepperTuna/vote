<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
		<title>설문조사 목록</title>
	</head>
	<body>
		<div class="container">
			<h2>진행중 설문</h2>
			<table class="table table-hover">
			<c:forEach items="${list}" var="voteVO">
				<c:if test="${voteVO.vStatus == '1'}">
				<tr>
					<td>번호 : ${voteVO.vIdx}</td>
					<td>${voteVO.vWriter}</td>
					<td><fmt:formatDate pattern="MM-dd HH:mm" value="${voteVO.vUpdateDate}" /></td>
				</tr>
				<tr>
					<td colspan="3"><a href="/readVote?vIdx=${voteVO.vIdx}">${voteVO.vTitle}</a></td>
				</tr>
				</c:if>
			</c:forEach>
			</table>
		
			<h2>완료된 설문</h2>
			<table class="table table-hover">
			<c:forEach items="${list}" var="voteVO">
				<c:if test="${voteVO.vStatus == '2'}">
				<tr>
					<td>번호 : ${voteVO.vIdx}</td>
					<td>${voteVO.vWriter}</td>
					<td><fmt:formatDate pattern="MM-dd HH:mm" value="${voteVO.vUpdateDate}" /></td>
				</tr>
				<tr>
					<td colspan="3"><a href="#">${voteVO.vTitle}</a></td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
		<button type="button" class="btn btn-info">설문 관리</button>
		<a href="/uploadForm"><button type="button" class="btn btn-primary">설문지 만들기</button></a>
		</div>
	</body>
</html>