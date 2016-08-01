<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문조사 목록</title>
</head>
<body>
   <table>
      <tr>
         <th>V_IDX</th>
         <th>V_WRITER</th>
         <th>V_TITLE</th>
         <th>V_DATE</th>
      </tr>
      <c:forEach items="${list}" var="voteVO">
         <tr>
            <td>${voteVO.vIdx}</td>
            <td>${voteVO.vWriter}</td>
            <td>${voteVO.vTitle}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" 
                  value="${voteVO.vUpdateDate}" /></td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>