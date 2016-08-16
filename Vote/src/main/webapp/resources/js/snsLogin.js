//네이버아디디로로그인 초기화 start
var naver_id_login = new naver_id_login("3yr90lvUPRm9hvhpImQP", "http://127.0.0.1:8080/snsLogin");
var state = naver_id_login.getUniqState();
naver_id_login.setButton("green", 3, 48);
naver_id_login.setDomain(".service.com");
naver_id_login.setState(state);
naver_id_login.init_naver_id_login();
//네이버아디디로로그인 초기화 Script end

//카카오로그인 초기화 Script start
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
				snsform.snsid.value = res.id;
				snsform.snstype.value = 1;
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
//카카오로그인 초기화 Script end

//네이버아디디로로그인 Callback페이지 처리 Script
// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
function naverSignInCallback() {
	// naver_id_login.getProfileData('프로필항목명');
	var snsform = document.snsform;
	snsform.snsid.value = naver_id_login.getProfileData('email');
	snsform.snstype.value = 2;
	snsform.submit();
}

// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");
//네이버아디디로로그인 Callback페이지 처리 Script end

//페이스북 로그인 처리 start
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
		version : 'v2.7' // 버전 2.7 사용
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
	js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.7";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// 이 호출은 statusChangeCallback()에서 이루어진다.
function testAPI() {
	console.log('Welcome!  Fetching your information.... ');
	FB.api('/me', function(response) {
		var snsform = document.snsform;
		snsform.snsid.value = response.id;
		snsform.snstype.value = 3;
		snsform.username.value = response.name;
		snsform.submit();
	});
}
//페이스북 로그인 처리 Script end