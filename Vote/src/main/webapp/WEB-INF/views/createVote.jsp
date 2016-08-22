<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html, charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/bootstrap/css/vote.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value='/resources/js/vote.js'/>" charset='utf-8'></script>
    <script>
   
		var img_plus = "<c:url value='/resources/image/img_plus.png'/>";
		var img_remove = "<c:url value='/resources/image/img_remove.png'/>";
		var img_upload = "<c:url value='/resources/image/img_upload_photo.png'/>";
   
	</script>
    <title>투표 등록</title>
</head>
<body>
	<div class='container'>
		<div id='content'>
			<form name='vote' action='/createVote' method='POST' enctype='multipart/form-data'>
				<input type="hidden" name="userid" value="${login.userid }">
            	<input type='text' class='vote-text' name='vote_text' placeholder='설문 제목을 입력하세요.'/>
				<ol id='question'>
					<li class='question-area'>
						<input type='text' class='question-text' placeholder='질문을 입력하세요.'/>
						<img src='<c:url value='/resources/image/img_plus.png'/>' class='add-question'/>
						<img src='<c:url value='/resources/image/img_remove.png'/>' class='remove-question'/>
   
						<ol class='question-choice'>
                           <li class='choice-area'>
                               <input type='text' class='choice-text' placeholder='선택지를 입력하세요.'/>
                               <img src='<c:url value='/resources/image/img_upload_photo.png'/>' class='img-file-upload'/>
                               <img src='<c:url value='/resources/image/img_plus.png'/>' class='add-choice'/>
                               <img src='<c:url value='/resources/image/img_remove.png'/>' class='remove-choice'/>
                        		<input type='file' class='choice-file'/>
							</li>
						</ol>
					</li>
				</ol>
				<div class='text-right'>
					<button type='button' class='btn btn-primary col-md-24' id='btn_submit'>제출</button><hr>
				</div>
				<input type="hidden" name="vote_length"/>
				<input type="hidden" name="choice_length"/>
			</form>
		</div>
	</div>
</body>
</html>