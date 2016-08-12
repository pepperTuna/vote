<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<!-- 로그인 버튼 노출 영역 -->
<div id="naver_id_login"></div>
<fb:login-button id="btn_login" scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>
<a id="kakao-login-btn"></a>
<!-- //로그인 버튼 노출 영역 -->

<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript">
	var naver_id_login = new naver_id_login("3yr90lvUPRm9hvhpImQP", "http://127.0.0.1:8080/snsLogin");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("white", 2,40);
	naver_id_login.setDomain(".service.com");
	naver_id_login.setState(state);
	//naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
</script>
<!-- //네이버아디디로로그인 초기화 Script -->

<!-- 카카오로그인 초기화 Script -->

<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('15b8c4e8b3be5e6462297f9437eb9ff4');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        // 로그인 성공시, API를 호출합니다.
        Kakao.API.request({
          url: '/v1/user/me',
          success: function(res) {
            var snsform = document.snsform;
            snsform.sns_id.value = res.id;
            snsform.sns_type.value = 1;
            snsform.submit();
          },
          fail: function(error) {
            alert(JSON.stringify(error));
          }
        });
      },
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
</script>
<!-- //카카오로그인 초기화 Script -->

<!-- 네이버아디디로로그인 Callback페이지 처리 Script -->
<script type="text/javascript">
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
		// naver_id_login.getProfileData('프로필항목명');
		// 프로필 항목은 개발가이드를 참고하시기 바랍니다.
		/* alert(naver_id_login.getProfileData('email') + naver_id_login.getProfileData('nickname')
				+ naver_id_login.getProfileData('age') + naver_id_login.getProfileData('id') 
				+ naver_id_login.getProfileData('name')); */
		
		var snsform = document.snsform;
		snsform.sns_id.value = naver_id_login.getProfileData('email');
		snsform.sns_type.value = 2;
		snsform.submit();
	}

	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
</script>
<!-- //네이버아디디로로그인 Callback페이지 처리 Script -->

<!-- 페이스북 로그인 처리 Script -->
<script>
   // This is called with the results from from FB.getLoginStatus().
   function statusChangeCallback(response) {
      console.log('statusChangeCallback');
      console.log(response);
      // response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다. 
      // 앱에서 현재의 로그인 상태에 따라 동작하면 된다.
      // FB.getLoginStatus().의 레퍼런스에서 더 자세한 내용이 참조 가능하다.
      if (response.status === 'connected') {
         // 페이스북을 통해서 로그인이 되어있다.
         testAPI();
      } else if (response.status === 'not_authorized') {
         // 페이스북에는 로그인 했으나, 앱에는 로그인이 되어있지 않다.
         document.getElementById('status').innerHTML = 'Please log '
               + 'into this app.';
      } else {
         // 페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.
         document.getElementById('status').innerHTML = 'Please log '
               + 'into Facebook.';
      }
   }

   // 이 함수는 누군가가 로그인 버튼에 대한 처리가 끝났을 때 호출된다.
   // onlogin 핸들러를 아래와 같이 첨부하면 된다.
   function checkLoginState() {
      FB.getLoginStatus(function(response) {
         statusChangeCallback(response);
      });
   }

   window.fbAsyncInit = function() {
      FB.init({
         appId : '182856515465043',
         cookie : true, // 쿠키가 세션을 참조할 수 있도록 허용
         xfbml : true, // 소셜 플러그인이 있으면 처리
         version : 'v2.1' // 버전 2.1 사용
      });

      // 자바스크립트 SDK를 초기화 했으니, FB.getLoginStatus()를 호출한다.
      //.이 함수는 이 페이지의 사용자가 현재 로그인 되어있는 상태 3가지 중 하나를 콜백에 리턴한다.
      // 그 3가지 상태는 아래와 같다.
      // 1. 앱과 페이스북에 로그인 되어있다. ('connected')
      // 2. 페이스북에 로그인되어있으나, 앱에는 로그인이 되어있지 않다. ('not_authorized')
      // 3. 페이스북에 로그인이 되어있지 않아서 앱에 로그인이 되었는지 불확실하다.
      //
      // 위에서 구현한 콜백 함수는 이 3가지를 다루도록 되어있다.

      FB.getLoginStatus(function(response) {
         statusChangeCallback(response);
      });

   };

   // SDK를 비동기적으로 호출
   (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id))
         return;
      js = d.createElement(s);
      js.id = id;
      js.src = "//connect.facebook.net/en_US/sdk.js";
      fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));

   // 로그인이 성공한 다음에는 간단한 그래프API를 호출한다.
   // 이 호출은 statusChangeCallback()에서 이루어진다.
   function testAPI() {
         console.log('Welcome!  Fetching your information.... ');
         FB.api('/me', function(response) {
              var snsform = document.snsform;
            snsform.sns_id.value = response.id;
            snsform.sns_type.value = 3;
            alert(snsform.sns_id.value);
             snsform.submit();
         });
   }
</script>
<!-- //페이스북 로그인 처리 Script -->

<form name="snsform" method="post" action="/user/login">
	<input type="hidden" name="sns_id"/>
	<input type="hidden" name="sns_type"/>
</form>
</body>
</html>