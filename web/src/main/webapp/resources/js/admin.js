$().ready(function(){

    $("form").validate({
        rules:{
            percent:{
                required: true,
                regexp: '[\\d+|\\d+.\\d+]'
            },
            username:{
                required: true,
                regexp: '^[a-z0-9_-]{3,16}$'
            },
            password:{
                required: true,
                regexp: '^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,12}$'
            },
            minSum:{
                required: true,
                regexp: '[\\d+|\\d+.\\d+]'
            },
            passport:{
                required: true,
                regexp: '[А-ЯЁ]{2,2}\\d{7,7}'
            },
            maxSum:{
                required: true,
                regexp: '[\\d+|\\d+.\\d+]'
            },
            period:{
                required: true,
                regexp: '\\d+',
                maxlength: 2
            },
            sum:{
                required: true,
                regexp: '[\\d+|\\d+.\\d+]'
            },
            surname:{
                required: true,
                regexp: '[a-zA-Zа-яёА-ЯЁ]+'
            },
            name:{
                required: true,
                regexp: '[a-zA-Zа-яёА-ЯЁ]+'
            },
            patronymic:{
                required:true,
                regexp: '[a-zA-Zа-яёА-ЯЁ]+'
            }
        },
        messages:{
            percent:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            username:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            password:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            minSum:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            passport:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            maxSum:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            period:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!',
                maxlength: 'The completed field does not meet the requirements!'
            },
            sum:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            surname:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            name:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            patronymic:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            }
        },
        errorElement: "div",
        errorPlacement: function(error, element) {
            element.after(error);
        }
    });


    jQuery.validator.addMethod(
        'regexp',
        function(value, element, regexp) {
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "The completed field does not meet the requirements!"
    );

});