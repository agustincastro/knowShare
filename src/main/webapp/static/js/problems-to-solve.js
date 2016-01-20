$(document).ready(function(){


    $("form").submit(function(e){
        e.preventDefault();
        e.stopPropagation();

        var selectedSource = $(this).parent("td").siblings().find("#select-source").val();
        if(selectedSource != 0){
            $(this).find("input[name=source]").val(selectedSource);
            this.submit();
        }

    });

});
