$().ready(function(){
    var url = document.location.pathname.substr(1);

    if(url == "registration") {
        $("#log_in").css("border-bottom", "1.7px dotted rgba(0,0,0,.3)");
        $("#registration").css("border-bottom", "none");
    }

    else if (url == "login") {
        $("#log_in").css("border-bottom", "none");
        $("#registration").css("border-bottom", "1.7px dotted rgba(0,0,0,.3)");
    }

    $("form").validate({
        rules:{
            username:{
                required: true,
                minlength: 7
            },
            password:{
                required: true,
                minlength: 7
            }
        },
        messages:{
            username:{
                required: "Поле обязательно для заполнения",
                minlength: "Минимум 7 символов"
            },
            password:{
                required: "Поле обязательно для заполнения",
                minlength: "Минимум 7 символов"
            }
        }
    });

});