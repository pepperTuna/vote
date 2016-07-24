/**
 * Created by jbkim on 2016-07-11.
 */
var Vote = function(question_no) {
    this.question_no = question_no;
    this.quetion_title = new String();
    this.choice = new Array();
    this.file = new Array();
};
Vote.prototype = {
    setQuestionTitle:function(question_title){
        this.question_title = question_title;
    },
    getQuestionTitle:function(){
        return this.question_title;
    },
    setChoice:function(choice){
        this.choice.push(choice);
    },
    getChoice:function() {
        return this.choice;
    },
    setFile:function(file){
        this.file.push(file);
    },
    getFile:function(){
        return this.file;
    }
};
Vote.prototype.constructor = Vote;

function createQtxtbox() {
    $('#question').append("<li class='question-area'> ");
    $('#question .question-area').last()
        .append("<input type='text' class='question-text' placeholder='질문을 입력하세요.'/> ")
        .append("<img src='/resources/img/img_plus.png' class='add-question'/> ")
        .append("<img src='/resources/img/img_remove.png' class='remove-question'/> ")
        .append("<ol class='question-choice'> ");

    createCtxtbox($('#question .question-area').children().last());
}

function createCtxtbox(that) {
    $(that).append("<li class='choice-area'> ");
    $(that).children().last()
        .append("<input type='text' class='choice-text' placeholder='선택지를 입력하세요.'/> ")
        .append("<img src='/resources/img/img_upload_photo.png' class='img-file-upload'/> ")
        .append("<input type='file' class='choice-file'/> ")
        .append("<img src='/resources/img/img_plus.png' class='add-choice'/> ")
        .append("<img src='/resources/img/img_remove.png' class='remove-choice'/> ");
}

function removeTxtbox(that) {
    that.parentNode.remove();
}

function hideRemovebtn(that) {
    if($(that).attr("class") == 'question-area') {
       if($('.question-area').parent().children().length == 1) {
      $('.question-area').find('.remove-question').hide();
       } else {
            $('.question-area').find('.remove-question').show();
       }
    } else if($(that).attr("class") == 'question-choice') {
       if($(that).children().length == 1) {
           $(that).find('.remove-choice').hide();
       } else {
           $(that).find('.remove-choice').show();
       }
    }
}



$(document).ready(function(){
	
	$.datepicker.regional['ko'] = {
	        closeText: '닫기',
	        prevText: '이전달',
	        nextText: '다음달',
	        currentText: '오늘',
	        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
	            '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
	        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
	            '7월','8월','9월','10월','11월','12월'],
	        dayNames: ['일','월','화','수','목','금','토'],
	        dayNamesShort: ['일','월','화','수','목','금','토'],
	        dayNamesMin: ['일','월','화','수','목','금','토'],
	        weekHeader: 'Wk',
	        dateFormat: 'yy-mm-dd',
	        firstDay: 0,
	        isRTL: false,
	        showMonthAfterYear: true,
	        yearSuffix: '',
	        showOn: 'both',
	        buttonText: "달력",
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        yearRange: 'c-99:c+99',
	};
	$.datepicker.setDefaults($.datepicker.regional['ko']);

    hideRemovebtn($('.question-area'));
    hideRemovebtn($('.question-choice'));

    $(document).on('click','.add-question', function(){

        createQtxtbox();

        hideRemovebtn(this.parentNode);

        hideRemovebtn($('#question').children().last().find('.question-choice'));

        $(window).scrollTop($(window).scrollTop + 122);

    });

    $(document).on('click','.add-choice', function(){

        createCtxtbox(this.parentNode.parentNode);

        hideRemovebtn(this.parentNode.parentNode);

        $(window).scrollTop($(window).scrollTop + 56);

    });

    $(document).on('click','.remove-question', function(){

        var tempThis = this.parentNode;

        removeTxtbox(this);

        hideRemovebtn(tempThis);

        $(window).scrollTop($(window).scrollTop - 56);

    });

    $(document).on('click','.remove-choice', function(){

        var tempThis = this.parentNode.parentNode;

        removeTxtbox(this);

        hideRemovebtn(tempThis);

        $(window).scrollTop($(window).scrollTop - 56);

    });

    $(document).on('click','.img-file-upload',function(e){
        e.preventDefault();
        var $this = $(this);
        $this.next().click();
    });


    $('#btn_submit').on('click',function(e){
        e.preventDefault();
        
        layer_open('layer2');
        
        var votesLength = $('.question').children().length;
        var votes = $('.question').children().first();

        for(var i=0;i<votesLength;i++){
            var questionText = votes.find('.question-text');
            questionText.eq(0).attr('name', 'question-'+(i+1));

            var choiceText = votes.find('.choice-text');
            for(var j=0;j<choiceText.length;j++){
                choiceText.eq(j).attr('name','choice-text-'+(i+1)+'-'+(j+1));
            }
            
            var choiceFile = votes.find('.choice-file');
            for(var j=0;j<choiceFile.length;j++){
                choiceText.eq(j).attr('name','choice-file-'+(i+1)+'-'+(j+1));
            }

            votes = votes.next();
        }
        document.vote.submit();
    });
});
