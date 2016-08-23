var Vote = function(question_no) {
    this.question_no = question_no;
    this.quetion_title = new String();
    this.choice = new Array();
    this.file = new Array();
};

Vote.prototype = {
    setQuestionTitle:function(question_title) {
        this.question_title = question_title;
    },
    getQuestionTitle:function() {
        return this.question_title;
    },
    setChoice:function(choice) {
        this.choice.push(choice);
    },
    getChoice:function() {
        return this.choice;
    },
    setFile:function(file) {
        this.file.push(file);
    },
    getFile:function() {
        return this.file;
    }
};

Vote.prototype.constructor = Vote;


function createQtxtbox() {

    $('#question').append("<li class='question-area'>");
    $('#question .question-area').last()
        .append("<input type='text' class='question-text' placeholder='질문을 입력하세요.'/>")
        .append("<img src=" + img_plus + " class='add-question'/>")
        .append("<img src=" + img_remove + " class='remove-question'/>")
        .append("<ol class='question-choice'>");

    createCtxtbox($('#question .question-area').children().last());
}

function createCtxtbox(that) {

    $(that).append("<li class='choice-area'>");
    $(that).children().last()
        .append("<input type='text' class='choice-text' placeholder='선택지를 입력하세요.'/>")
        .append("<img src=" + img_upload + " class='img-file-upload'/>")
        .append("<img src=" + img_plus + " class='add-choice'/>")
        .append("<img src=" + img_remove + " class='remove-choice'/>")
        .append("<input type='file' class='choice-file'/>");

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


function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function (e) {

			$(input).prev().prev().prev().attr('src', e.target.result);
			
			$(input).prev().prev().prev().find("img").attr('src', e.target.result);
			
		}

		reader.readAsDataURL(input.files[0]);
	}
}



$(document).ready(function(){

    $(document).on('click','.img-file-upload', function(){
        var $this = $(this);
        $this.next().next().next().click();
        
        $this.next().next().next().on('change', function(){
            readURL(this);
        });

    });

	hideRemovebtn($('.question-area'));
	hideRemovebtn($('.question-choice'));

	$(document).on('click','.add-question', function(){

		createQtxtbox();

		hideRemovebtn(this.parentNode);

		hideRemovebtn($('#question').children().last().find('.question-choice'));

	$(window).scrollTop($(window).scrollTop() + 122);

	});

    $(document).on('click','.add-choice', function(){

       createCtxtbox(this.parentNode.parentNode);

       hideRemovebtn(this.parentNode.parentNode);

        $(window).scrollTop($(window).scrollTop() + 56);

    });

    $(document).on('click','.remove-question', function(){

       var tempThis = this.parentNode;

       removeTxtbox(this);

        hideRemovebtn(tempThis);

        $(window).scrollTop($(window).scrollTop() - 122);

    });

    $(document).on('click','.remove-choice', function(){

       var tempThis = this.parentNode.parentNode;

      removeTxtbox(this);

        hideRemovebtn(tempThis);

        $(window).scrollTop($(window).scrollTop() - 56);

    });

    $('#btn_submit').on('click',function(e){

       e.preventDefault();
        var votesLength = $('#question').children().length;
        var votes = $('#question').children();
        var choiceLength = ''; 

        for(var i = 0; i < votesLength; i++) {
           
           var questionText = votes.find('.question-text');
            questionText.eq(0).attr('name', 'question-' + (i + 1));

            var choiceText = votes.eq(0).find('.choice-text');
            
            for(var j = 0; j < choiceText.length; j++) {
               
                choiceText.eq(j).attr('name','choice-text-' + (i + 1) + '-' + (j + 1));
                
            }
            

            var choiceFile = votes.find('.choice-file');
            
            for(var j = 0; j < choiceFile.length; j++) {
               
                choiceFile.eq(j).attr('name','choice-file-' + (i + 1) + '-' + (j + 1));
            }

            i > 0 ? choiceLength += '|' : '';
           
            choiceLength += choiceText.length;

            votes = votes.next();
        }
        //alert(votesLength + " /// "+choiceLength);
   
        var form = document.vote;
        form.vote_length.value = votesLength;
        form.choice_length.value = choiceLength;
        
        form.submit();

    });
});