<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="/resources/css/vote.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/datePopup.css"/>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
    <script type="text/javascript" src="/resources/js/datePopup.js"></script>
    <script type="text/javascript" src="/resources/js/vote.js" ></script>
    
    <title>투표 등록22222</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class='container'>
    <div class='content'>
	<form action="/test" method="post" enctype="multipart/form-data">
            <ol id='question'>
                <li class='question-area'>
                    <input type='text' class='question-text' placeholder='질문을 입력하세요.'/>
          			<img src='/resources/img/img_plus.png' class='add-question'/>
                   <img src='/resources/img/img_remove.png' class='remove-question'/>

                    <ol class='question-choice'>
                        <li class='choice-area'>
                            <input type='text' class='choice-text' placeholder='선택지를 입력하세요.'/>
                            <img src='/resources/img/img_upload_photo.png' class='img-file-upload'/>
                            <input type='file' class='choice-file'/>
                            <img src='/resources/img/img_plus.png' class='add-choice'/>
                            <img src='/resources/img/img_remove.png' class='remove-choice'/>
                        </li>
                    </ol>
                </li>
            </ol>
    </form>
    </div>
   
    <button type='button' id='btn_submit'>제출</button>
</div>
</body>

</body>
</html>