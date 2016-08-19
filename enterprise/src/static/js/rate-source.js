
$(document).ready(function(){


    $("input[name='perception_flag']").change(function(e){

        if($(this).val() == "true"){
            $("input[name='question_1']").removeAttr('disabled');
            $("input[name='question_2']").removeAttr('disabled');
        }else{
            $("input[name='question_1']").attr('disabled', $(this).val());
            $("input[name='question_2']").attr('disabled', $(this).val());

        }

    });


    $("input[name^='question_']").change(function(e){

        $(this).parents("fieldset").first().removeClass("required");

    });

    var form = $("#rate-source-form");
    form.submit(function(e){
        e.preventDefault();
        e.stopPropagation();

        if(isValid()){
            this.submit();
        }
    });

    var isValid = function(){

        var questions = ["question_1", "question_2", "question_3",
            "question_4", "question_5", "question_6", "question_7",
            "question_8", "question_9", "question_10"];

        var isValid = true;
        var invalidQuestion = undefined;
        $.each(questions, function(index, elem){

            var q = $("input[name='"+elem+"']:checked").size() > 0 ? $("input[name='"+elem+"']:checked").val() : $("select[name='"+elem+"']").val();
            if(elem != "question_1" && elem != "question_2" && q == undefined){
                $("input[name='"+elem+"']").parents("fieldset").first().addClass("required")
                invalidQuestion = elem;
                isValid = false;

            }

        });
        if(invalidQuestion!=undefined)
            window.location = "ratesource#"+invalidQuestion;

        return isValid;

    }
});
