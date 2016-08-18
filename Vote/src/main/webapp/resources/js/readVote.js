$(document).ready(function(){
	
	$('[data-toggle="popover"]').popover({
		html: true,
		trigger: 'manual',
		content: function () {
            return '<img src="' + $(this).children().first().attr('src') + '" width="240" style="-webkit-touch-callout:none"/>';
		}
	}).on("mousedown touchstart", function (e) {
		e.preventDefault();
        var _this = this;
        $(this).popover("show");
        $(this).siblings(".popover").on("mouseleave", function () {
            $(_this).popover('hide');
        });
    }).on("mouseup touchend", function () {
        var _this = this;
        setTimeout(function () {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide")
            }
        }, 100);
    });
	
	$('#btn_reset').on('click', function(e) {
		$("input:radio[name*='choice']").removeAttr('checked');
	})
	
	$('#btn_submit').on('click', function(e) {
		if(confirm("투표를 마치시겠습니까?") == true){
			
			var map = new Object();
			
			var qLength = $('.question-title').length;
			map.length = qLength;
			
			for(var i=1;i<=qLength;i++){
				var checked = $('input:radio[class="radio-'+i+'"]:checked').attr('name');

				if(checked == null){
					return;
				}else{
					var index = checked.substring(checked.lastIndexOf('-')+1, checked.length);
					map[''+i] = index;
				}
				
			}
			
			var jsonString = JSON.stringify(map);
			
			$.ajax({
				url:'/createResult',
				contentType : 'application/json;charset=UTF-8',
				type:'post',
				dataType:'json',
				data:jsonString,
				success:function(data){
					console.log(data);
				}
			});			
			
			alert("투표를 완료했습니다.");
		} else {
			return;
		}
	})
});