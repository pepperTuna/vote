$(document).ready(function(){	
	$(function () {
	    $('[data-toggle="popover"]').popover({
	    	html: true,
			content: function() {
				return '<img src="' + $(this).children().first().attr('src') + '" width="300" />';
			}
		})
	})
	/*
	$(document).on("click touchstart", function (e) {
		var container = $('[data-toggle="popover"]');
		if (!container.is(e.target) && container.has(e.target).length === 0) {
			container.popover({
		    	html: true,
				content: function() {
					return '<img src="' + $(this).children().first().attr('src') + '" width="140" />';
				}
			})
		}
	})
	*/
	$('#btn_reset').on('click',function(e) {
		$("input:radio[name*='choice']").removeAttr('checked');
	})
});