<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
   <link href="<c:url value="/resources/bootstrap/css/snsLogin.css"/>" rel="stylesheet">
   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
   <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
   <script src="<c:url value="/resources/js/userJoin.js"/>"></script>
<title>회원 가입</title>
</head>
<body>
   <div class="container">
      <form id="frmJoin" name="frmJoin" method="POST" class="form-signin">
         <h2 class="form-signin-heading">회원가입</h2>
            <input type="hidden" id="snstype" name="snstype" value="0">
            <input type="text" name="userid" id="userid" class="form-control" placeholder="ID를 입력해주세요">
            <p class="pull-right"><button type="button" name="duplbtn" id="duplbtn" class="btn btn-info btn-sm">ID 중복 확인</button></p>
         <input type="password" name="userpw" id="userpw" class="form-control" placeholder="PW를 입력해주세요">
         <input type="password" id="userpwCh" class="form-control" placeholder="PW를 한번 더 입력해주세요">
         <input type="text" id="username" class="form-control" placeholder="이름을 입력해주세요"><br>
         <button type="button" id="join" name="join"   class="btn btn-lg btn-primary btn-block">가입하기</button>
      </form>
   </div>
</body>
</html>