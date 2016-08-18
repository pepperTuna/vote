<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
	<!-- 로그인 버튼 노출 영역 -->
	<div id="naver_id_login"></div>
	<div class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false">페이스북으로 로그인</div>
	<br>
	<a id="kakao-login-btn"></a>
	
	<!-- 로그인 버튼 노출 영역 -->
	<form name="snsform" method="post" action="/user/login">
		<input type="hidden" name="snsid"/>
		<input type="hidden" name="snstype"/>
		<input type="hidden" name="username"/>
	</form>
	<script type="text/javascript" src="../resources/js/snsLogin.js" charset="UTF-8"></script>
</body>
</html>