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
			alert("투표를 완료했습니다.");
		} else {
			return;
		}
	})
});