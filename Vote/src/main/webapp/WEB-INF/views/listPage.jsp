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
   <title>설문조사 목록</title>
</head>
<body>
   <div class="container">
      <h2>만든 설문 목록</h2>
      
      <table class="table table-hover">
      <c:forEach items="${limitedList}" var="voteVO">
         <tr>
            <td>${voteVO.vtitle}</td>
            <td>${voteVO.vwriter}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${voteVO.vupdatedate}" /></td>
         </tr>
      </c:forEach>
      </table>
      
      <table class="table table-hover">
         <tr>
            <td>
               <c:if test="${pageMaker.page>1}">
               <a href="/listPage?page=${pageMaker.page-1}&perPageNum=${pageMaker.perPageNum}"> < </a> 
               </c:if>
            </td>
            <c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" step="1">
               <td><a href="/listPage?page=${i}&perPageNum=${pageMaker.perPageNum}" <c:if test="${pageMaker.page == i}">style='color:orange'</c:if>> ${i} </a></td>
            </c:forEach>
            <td>
               <c:if test="${pageMaker.page<pageMaker.totalEndPageNo}">
               <a href="/listPage?page=${pageMaker.page+1}&perPageNum=${pageMaker.perPageNum}">
                   > 
               </a> 
               </c:if>
            </td>
         </tr>
      </table>
      
      <a href=#><button type="button" class="btn btn-info">설문 관리</button></a>
      <a href="/uploadForm"><button type="button" class="btn btn-primary">설문지 만들기</button></a>
   </div>
</body>
</html>