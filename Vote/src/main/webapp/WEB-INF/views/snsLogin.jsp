<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
   <link href="<c:url value="/resources/bootstrap/css/snsLogin.css"/>" rel="stylesheet">
   <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
   <script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
   <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
   <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
   <title>시작하기</title>
   <script>
   var msg = '${MSG}';
   if (msg == 'fail') {
      alert("아이디와 비밀번호를 확인하세요.");
   }
   
   </script>
</head>
<body>
   <div class="container">
      <form action="/snsLogin" method="POST" class="form-signin">
         <h2 class="form-signin-heading">시작하기</h2>
         <input type="text" name="userid" class="form-control" placeholder="아이디 입력">
         <input type="password" name="userpw" class="form-control" placeholder="비밀번호 입력">
         <button class="btn btn-lg btn-primary btn-block" type="submit">로그인하기</button>
         <h5><a href="/join">아직 회원이 아니십니까?</a></h5>
         <h2 class="form-signin-heading">SNS로 로그인하기</h2>
         <div id="naver_id_login"></div>
         <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">페이스북으로 로그인하기</fb:login-button>
         
         <!-- <div class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false">페이스북으로 로그인</div> -->
         <br><a id="kakao-login-btn"></a>
         <input type="hidden" name="snstype" value="0" />
      </form>
   </div>
   <form name="snsform" method="post" action="/snsLogin">
      <input type="hidden" name="snsid" />
      <input type="hidden" name="snstype" />
      <input type="hidden" name="username" />
   </form>
   <script type="text/javascript" src="<c:url value="/resources/js/snsLogin.js"/>" charset="UTF-8"></script>
</body>
</html>