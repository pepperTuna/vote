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
   <div class='container'>
      <div class="row h5">
         <div class="col-xs-3"><strong>설문번호</strong></div>
         <div class="col-xs-9">${voteVO.vidx}</div><br><br>
         <div class="col-xs-3"><strong>작성자</strong></div>
         <div class="col-xs-9">${voteVO.vwriter}</div><br><br>
         <div class="col-xs-3"><strong>등록 날짜</strong></div>
         <div class="col-xs-9"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${voteVO.vupdatedate}"></fmt:formatDate></div><br><br>
      </div>
      <hr>
      <h3>${voteVO.vtitle}</h3><br>
      <div class="alert alert-info" role="alert">
         <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
          썸네일을 누르고 있으면 <strong>미리보기가 활성화</strong>됩니다.
      </div>

      <c:if test="${voteVO.vstatus eq '2'}">
      <div class="alert alert-danger" role="alert">
         <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
          이 설문은 이미 <strong>조사기간이 만료</strong>된 설문입니다.            
      </div>
      </c:if>
      <div class='col-md-12'>
         <c:forEach items ="${list}" var="voteQuestionVO" varStatus="status">
   				<%-- ${resultList[status.index].cno} --%>
            <ul>
               <!-- vidx = ${voteQuestionVO.vidx} -->
            <c:choose>
               <c:when test="${voteQuestionVO.cno eq '0'}">
                  <dt class='question-title'>${voteQuestionVO.qno}. ${voteQuestionVO.content}</dt>
               </c:when>
               <c:otherwise>
                  <li id="${voteQuestionVO.cno }" class="cno" value="${voteQuestionVO.cno }">${voteQuestionVO.content}
                  <c:if test="${voteQuestionVO.attach ne null }">
                     <a tabindex="0" role="button" data-toggle="popover" data-trigger="focus" data-placement="top" data-content=""><img src='${voteQuestionVO.attach}' class="img-thumbnail" width="50"></a>
                  </c:if>
                  </li>
               </c:otherwise>                                                                                           
            </c:choose>
            </ul>
         </c:forEach>
         
         <!-- bootstrap.css line 1447 '0 -> 20' -->
      </div>
      <div class='text-right'>
         <button type='button' class='btn btn-warning col-md-24' id='btn_reset'>초기화</button>
         <button type='button' class='btn btn-primary col-md-24' id='btn_submit'>제출</button><hr>
         <address>
            <strong>github.com/JONGBIN-KIM/vote</strong><br>
            Seoul, South Korea<br>
            <abbr title="Phone">P:</abbr> (123) 456-7890
         </address>
         </div>
   </div>
   
	<div class="container">
		<c:forEach items="${resultList}" var="ResultVO">
			${ResultVO.qno }번에  ${ResultVO.cno }번 대답함	<br/>
		</c:forEach>
		
		<c:forEach items="${questionList}" var="VoteQuestionVO">
			${VoteQuestionVO.qno }번에  ${VoteQuestionVO.cno }번 의  ${VoteQuestionVO.content } <br/>
		</c:forEach>
	</div>
</body>
	<script>
$(function(){
	var list1 = new Array();
	<c:forEach items="${resultList}" var="item1">
	<c:if test="${item1.ruser == login.userid }">
	list1.push("${item1.cno}");
	</c:if>
	</c:forEach>
	var abc = $("ul");
	for ( var i = 0; i < list1.length; i++) {
		for(var j=0 ;j<abc.length;j++){
			if(list1[i]==$("ul li:nth-child(j)").val()){
				alert("시발");
			};
		}
	}
	
});
</script>
</html>