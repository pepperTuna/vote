<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
		<title>설문조사 목록</title>
	</head>
	<body>
		<div class="container">
			<h2>진행중 설문</h2>
			<table class="table table-hover">
			<c:forEach items="${list}" var="voteVO">
				<c:if test="${voteVO.vstatus == '1'}">
				<tr>
					<td>번호 : ${voteVO.vidx}</td>
					<td>${voteVO.vwriter}</td>
					<td><fmt:formatDate pattern="MM-dd HH:mm" value="${voteVO.vupdatedate}" /></td>
				</tr>
				<tr>
					<td colspan="3"><a href="/readVote?vidx=${voteVO.vidx}">${voteVO.vtitle}</a></td>
				</tr>
				</c:if>
			</c:forEach>
			</table>

			<h2>완료된 설문</h2>
			<table class="table table-hover">
			<c:forEach items="${list}" var="voteVO">
				<c:if test="${voteVO.vstatus == '2'}">
				<tr>
					<td>번호 : ${voteVO.vidx}</td>
					<td>${voteVO.vwriter}</td>
					<td><fmt:formatDate pattern="MM-dd HH:mm" value="${voteVO.vupdatedate}" /></td>
				</tr>
				<tr>
					<td colspan="3"><a href="/readVote?vidx=${voteVO.vidx}">${voteVO.vtitle}</a></td>
				</tr>
				</c:if>
			</c:forEach>
			</table>
			<a href=#><button type="button" class="btn btn-info">설문 관리</button></a>
			<a href="/createVote"><button type="button" class="btn btn-primary">설문지 만들기</button></a>
		</div>
	</body>
</html>