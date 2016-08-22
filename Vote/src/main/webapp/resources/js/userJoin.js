function idCheck() {
	if ($("#userid").val()=="") {
		alert("아이디를 입력해주세요.");
		return false;
	} else {
		return true;
	}
}
// pw확인
function pwCheck() {
	if ($("#userpw").val()=="") {
		alert("비밀번호를 입력해주세요.");
		
		return false;
	} else {
		return true;
	}
}
function nameCheck() {
	if ($("#username").val()=="") {
		alert("이름 입력해주세요.");
		
		return false;
	} else {
		return true;
	}
}
// 비밀번호와 비밀번호 확인 일치여부
function pwCheck2() {
	if ($("#userpwCh").val() != frmJoin.userpw.value) {
		alert("비밀번호와 일치하지 않습니다.");
		return false;
	} else {
		return true;
	}
}
$(function() {
	var userid = $("#userid");
	var userpw = $("#userpw");
	var username = $("#username");
	var snstype = $("#snstype");
	var duplch = false;
	
	$("#userid").focusout(function() {
		duplch=false;
		idCheck();
	});
	$("#duplbtn").click(function() {
		$.ajax({
			method : "POST",
			url : "/duplCheck",
			data : {
				userid : encodeURI(userid.val())
			},
			success : function(result) {
				if (result == 0) {
					duplch = true;
					
					alert("사용하실 수 있는 아이디입니다.");

				} else {
					alert("사용하실 수 없는 아이디입니다.");
				}
			},
			error : function(request, status, error) {
				alert("code: " + request.status + "\n" + "error:" + error);
			}
		});
	});
	$("#userpw").focusout(function() {
		pwCheck();
	});
	$("#userpwCh").focusout(function() {
		pwCheck2();
	});
	$("#username").focusout(function(){
		nameCheck();
	});
	$("#join").click(function() {
						if (idCheck() && pwCheck() && pwCheck2()) {
							if (duplch) {
								$.ajax({
											method : "POST",
											url : "addUser",
											contentType : "application/x-www-form-urlencoded; charset=UTF-8",
											data : {
												snstype : snstype.val(),
												userid : userid.val(),
												userpw : userpw.val(),
												username : username.val()
											},
											success : function(result) {
												if (result == 1) {
													alert("회원가입 되었습니다.");
													location.href="/";
												} else {
													alert("회원가입에 실패했습니다.");
													location.href="/join";
												}
											},
											error : function(request, status,
													error) {
												alert("code: " + request.status
														+ "\n" + "error:"
														+ error);
											}
										});
							} else if (!duplch) {
								alert("중복확인을 해주세요.");
							}
						}
					});
});