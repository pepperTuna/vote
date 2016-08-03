$(document).ready(function(){
	var image = "<img src='../resources/image/cafe.jpg' width='140' />";
	$(function () {
	    $('[data-toggle="popover1"]').popover({
	    	html: true,
			content: image
		})
	})
	
	$(function () {
	    $('[data-toggle="popover"]').popover({
	    	html: true,
			content: function() {
				return '<img src="' + $(this).children().first().attr('src') + '" width="140" />';
			}
		})
	})
	
	$('#btn_reset').on('click',function(e) {
		$("input:radio[name*='choice']").removeAttr('checked');
	})
});