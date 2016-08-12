<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/vote.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/vote.js" charset='utf-8'></script>
    <title>투표 등록</title>
</head>
<body>
<div id='container'>
    <div id='content'>
	<form name='vote' action='/uploadForm' method='POST' enctype='multipart/form-data'>
			<input type='text' class='title-text' placeholder='투표 제목을 입력하세요.'/>
	
            <ol id='question'>
                <li class='question-area'>
                    <input type='text' class='question-text' placeholder='질문을 입력하세요.'/>
		    		<img src='../resources/image/img_plus.png' class='add-question'/>
            	    <img src='../resources/image/img_remove.png' class='remove-question'/>

                    <ol class='question-choice'>
                        <li class='choice-area'>
                            <input type='text' class='choice-text' placeholder='선택지를 입력하세요.'/>
                            <img src='../resources/image/img_upload_photo.png' class='img-file-upload'/>
                            <input type='file' class='choice-file'/>
                            <img src='../resources/image/img_plus.png' class='add-choice'/>
                            <img src='../resources/image/img_remove.png' class='remove-choice'/>
                        </li>
                    </ol>
                </li>
            </ol>
            <input type="hidden" name="vote_length"/>
            <input type="hidden" name="choice_length"/>
            <input type="hidden" name="vote_title"/>
		</form>
    </div>
    <button type='button' id='btn_submit'>제출</button>
</div>
</body>
</html>