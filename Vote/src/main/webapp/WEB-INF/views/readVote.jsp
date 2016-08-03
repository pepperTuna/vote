<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='ko'>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/bootstrap.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../resources/js/readVote.js" charset='utf-8'></script>
	<title>앙 설문띠</title>
</head>
<body>
	<div class='container'>
		<div class='text-right'>
			<label>Survey Number: ${voteVO.vIdx}</label><br>
			<label>Writer: ${voteVO.vWriter}</label><br>
			<label><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${voteVO.vUpdateDate}" /></label><br><br><br>
		</div>
		<h3>${voteVO.vTitle}</h3><br>
		<div class='col-md-6 .col-md-offset-3'>
			<c:forEach items ="${list}" var="voteQuestionVO">
				<dl>
					<!-- vIdx = ${voteQuestionVO.vIdx} -->
				<c:choose>
					<c:when test="${voteQuestionVO.cNo eq '0'}">
						<dt>${voteQuestionVO.qNo}. ${voteQuestionVO.content}</dt>
					</c:when>
					<c:otherwise>
						<dd><input type='radio' name='choice-${voteQuestionVO.vIdx}-${voteQuestionVO.qNo}-${voteQuestionVO.cNo}'>${voteQuestionVO.content}
						<c:if test="${voteQuestionVO.attach ne null }">
							<a tabindex="0" role="button" data-toggle="popover" data-trigger="focus" title='${voteQuestionVO.attachType}' data-content=""><img src='${voteQuestionVO.attach}' class="img-thumbnail" width="50"></a>
						</c:if>
						</dd>
					</c:otherwise>																														 
				</c:choose>
				</dl>
			</c:forEach>
			<!-- bootstrap.css line 1447 '0 -> 20' -->
		</div>
		<button type='button' class='btn btn-primary col-md-offset-9' id='btn_submit'>제출</button>
		<div class='text-right'>
			<address>
			<strong>github.com/JONGBIN-KIM/vote</strong><br>
			Seoul, South Korea<br>
			<abbr title="Phone">P:</abbr> (123) 456-7890
			</address>
   		</div>
	</div>
</body>
</html>