<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../resources/bootstrap/css/vote.css" />
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/vote.js" charset='utf-8'></script>
<title>설문 수정</title>
</head>
<body>
   <div id='container'>
      <div id='content'>
         <form name='vote' action='/updateVote' method='POST' enctype='multipart/form-data'>
            <input type='hidden' name='vidx' value='${voteVO.vidx }'/>
            <input type='hidden' name='vote_text' value='${voteVO.vtitle }'/>
            제목 <span class='vote-text'>${voteVO.vtitle}</span>
            <ol id='question'>
               <c:forEach items="${list}" var="voteQuestionVO" varStatus="status">
                  <c:if test="${not status.first && status.current.cno eq 0}">
            </ol>
            </li>
                  </c:if>
                  <c:choose>
                     <c:when test="${voteQuestionVO.cno eq '0'}">
                  <li class='question-area'><input type='text'
                     class='question-text' value='${voteQuestionVO.content}' /> <img
                     src='../resources/image/img_plus.png' class='add-question' /> <img
                     src='../resources/image/img_remove.png' class='remove-question' />
                     <ol class='question-choice'>
                     </c:when>
                     <c:otherwise>
                  <li class='choice-area'><input type='text'
                     class='choice-text'   value='${voteQuestionVO.content}'> <img
                     src='../resources/image/img_upload_photo.png'
                     class='img-file-upload' /> <input type='file'
                     class='choice-file' /> <img
                     src='../resources/image/img_plus.png' class='add-choice' /> <img
                     src='../resources/image/img_remove.png' class='remove-choice' />
                  </li>
                     </c:otherwise>
                  </c:choose>
                  <c:if test="${status.last}">
               </ol>
               </li>
                  </c:if>
               </c:forEach>
            </ol>
            <input type="hidden" name="vote_length" /> <input type="hidden" name="choice_length" />
         </form>
      </div>
      <button type='button' id='btn_submit'>제출</button>
   </div>
</body>
</html>