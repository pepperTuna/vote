<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="../resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/snsLogin.css" rel="stylesheet">
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<title>시작하기</title>
</head>
<body>
	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">시작하기</h2>
			<input type="text" id="inputId" class="form-control" placeholder="아이디 입력">
			<input type="password" id="inputPassword" class="form-control" placeholder="비밀번호 입력">
			<button class="btn btn-lg btn-primary btn-block" type="submit">로그인하기</button><br>
			<a href="/join"><button class="btn btn-lg btn-primary btn-block">가입하기</button></a>
			<h2 class="form-signin-heading">SNS로 로그인하기</h2>
			<div id="naver_id_login"></div>
			<div class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false">페이스북으로 로그인</div>
			<br><a id="kakao-login-btn"></a>
		</form>
	</div>
	<form name="snsform" method="post" action="/user/login">
		<input type="hidden" name="snsid" />
		<input type="hidden" name="snstype" />
		<input type="hidden" name="username" />
	</form>
	<script type="text/javascript" src="../resources/js/snsLogin.js" charset="UTF-8"></script>
</body>
</html>