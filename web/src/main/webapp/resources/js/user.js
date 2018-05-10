$().ready(function(){

    var byn = parseFloat($("#costUSD").val())*parseFloat($("#usd").val());
    $("#byn").val(byn.toFixed(2));
    $("#usd").val(1.00);
    var eur = (parseFloat($("#costUSD").val())/parseFloat($("#costEUR").val()))*parseFloat($("#usd").val());
    $("#eur").val(eur.toFixed(2));
    var rub = (parseFloat($("#costUSD").val())/parseFloat($("#costRUB").val()))*parseFloat($("#usd").val());
    $("#rub").val(rub.toFixed(2));

    $("#byn").change(function () {
        var usd = parseFloat($("#byn").val())/parseFloat($("#costUSD").val());
        $("#usd").val(usd.toFixed(2));
        eur = parseFloat($("#byn").val())/parseFloat($("#costEUR").val());
        $("#eur").val(eur.toFixed(2));
        rub = parseFloat($("#byn").val())/parseFloat($("#costRUB").val());
        $("#rub").val(rub.toFixed(2));
    });

    $("#usd").change(function () {
        byn = parseFloat($("#costUSD").val())*parseFloat($("#usd").val());
        $("#byn").val(byn.toFixed(2));
        eur = (parseFloat($("#costUSD").val())/parseFloat($("#costEUR").val()))*parseFloat($("#usd").val());
        $("#eur").val(eur.toFixed(2));
        rub = (parseFloat($("#costUSD").val())/parseFloat($("#costRUB").val()))*parseFloat($("#usd").val());
        $("#rub").val(rub.toFixed(2));
    });

    $("#eur").change(function () {
        byn = parseFloat($("#costEUR").val())*parseFloat($("#eur").val());
        $("#byn").val(byn.toFixed(2));
        var usd = byn/parseFloat($("#costUSD").val());
        $("#usd").val(usd.toFixed(2));
        rub = byn/parseFloat($("#costRUB").val());
        $("#rub").val(rub.toFixed(2));
    });

    $("#rub").change(function () {
        byn = parseFloat($("#costRUB").val())*parseFloat($("#rub").val());
        $("#byn").val(byn.toFixed(2));
        var usd = byn/parseFloat($("#costUSD").val());
        $("#usd").val(usd.toFixed(2));
        eur = byn/parseFloat($("#costEUR").val());
        $("#eur").val(eur.toFixed(2));

    });

    $("#achat").click(function () {
        $("#achat").css({"text-decoration": "none"});
        $("#vente").css({"text-decoration":"underline"});

        var byn = parseFloat($("#costUSD").val())*parseFloat($("#usd").val());
        $("#byn").val(byn.toFixed(2));
        $("#usd").val(1.00);
        var eur = (parseFloat($("#costUSD").val())/parseFloat($("#costEUR").val()))*parseFloat($("#usd").val());
        $("#eur").val(eur.toFixed(2));
        var rub = (parseFloat($("#costUSD").val())/parseFloat($("#costRUB").val()))*parseFloat($("#usd").val());
        $("#rub").val(rub.toFixed(2));

        $("#byn").change(function () {
            var usd = parseFloat($("#byn").val())/parseFloat($("#costUSD").val());
            $("#usd").val(usd.toFixed(2));
            eur = parseFloat($("#byn").val())/parseFloat($("#costEUR").val());
            $("#eur").val(eur.toFixed(2));
            rub = parseFloat($("#byn").val())/parseFloat($("#costRUB").val());
            $("#rub").val(rub.toFixed(2));
        });

        $("#usd").change(function () {
            byn = parseFloat($("#costUSD").val())*parseFloat($("#usd").val());
            $("#byn").val(byn.toFixed(2));
            eur = (parseFloat($("#costUSD").val())/parseFloat($("#costEUR").val()))*parseFloat($("#usd").val());
            $("#eur").val(eur.toFixed(2));
            rub = (parseFloat($("#costUSD").val())/parseFloat($("#costRUB").val()))*parseFloat($("#usd").val());
            $("#rub").val(rub.toFixed(2));
        });

        $("#eur").change(function () {
            byn = parseFloat($("#costEUR").val())*parseFloat($("#eur").val());
            $("#byn").val(byn.toFixed(2));
            var usd = byn/parseFloat($("#costUSD").val());
            $("#usd").val(usd.toFixed(2));
            rub = byn/parseFloat($("#costRUB").val());
            $("#rub").val(rub.toFixed(2));
        });

        $("#rub").change(function () {
            byn = parseFloat($("#costRUB").val())*parseFloat($("#rub").val());
            $("#byn").val(byn.toFixed(2));
            var usd = byn/parseFloat($("#costUSD").val());
            $("#usd").val(usd.toFixed(2));
            eur = byn/parseFloat($("#costEUR").val());
            $("#eur").val(eur.toFixed(2));

        });
    });

    $("#vente").click(function () {
        $("#vente").css({"text-decoration": "none"});
        $("#achat").css({"text-decoration":"underline"});

        var byn = parseFloat($("#saleUSD").val())*parseFloat($("#usd").val());
        $("#byn").val(byn.toFixed(2));
        $("#usd").val(1.00);
        var eur = (parseFloat($("#saleUSD").val())/parseFloat($("#saleEUR").val()))*parseFloat($("#usd").val());
        $("#eur").val(eur.toFixed(2));
        var rub = (parseFloat($("#saleUSD").val())/parseFloat($("#saleRUB").val()))*parseFloat($("#usd").val());
        $("#rub").val(rub.toFixed(2));

        $("#byn").change(function () {
            var usd = parseFloat($("#byn").val())/parseFloat($("#saleUSD").val());
            $("#usd").val(usd.toFixed(2));
            eur = parseFloat($("#byn").val())/parseFloat($("#saleEUR").val());
            $("#eur").val(eur.toFixed(2));
            rub = parseFloat($("#byn").val())/parseFloat($("#saleRUB").val());
            $("#rub").val(rub.toFixed(2));
        });

        $("#usd").change(function () {
            byn = parseFloat($("#saleUSD").val())*parseFloat($("#usd").val());
            $("#byn").val(byn.toFixed(2));
            eur = (parseFloat($("#saleUSD").val())/parseFloat($("#saleEUR").val()))*parseFloat($("#usd").val());
            $("#eur").val(eur.toFixed(2));
            rub = (parseFloat($("#saleUSD").val())/parseFloat($("#saleRUB").val()))*parseFloat($("#usd").val());
            $("#rub").val(rub.toFixed(2));
        });

        $("#eur").change(function () {
            byn = parseFloat($("#saleEUR").val())*parseFloat($("#eur").val());
            $("#byn").val(byn.toFixed(2));
            var usd = byn/parseFloat($("#saleUSD").val());
            $("#usd").val(usd.toFixed(2));
            rub = byn/parseFloat($("#saleRUB").val());
            $("#rub").val(rub.toFixed(2));
        });

        $("#rub").change(function () {
            byn = parseFloat($("#saleRUB").val())*parseFloat($("#rub").val());
            $("#byn").val(byn.toFixed(2));
            var usd = byn/parseFloat($("#saleUSD").val());
            $("#usd").val(usd.toFixed(2));
            eur = byn/parseFloat($("#saleEUR").val());
            $("#eur").val(eur.toFixed(2));

        });
    });

    $('#summa').change(function () {
        $('#comission').val(($('#summa').val()*0.1).toFixed(2));
        var com = $('#comission').val();
        var s = $('#summa').val()
        var sAll= parseFloat(com)+parseFloat(s);
        $('#allSumma').val(sAll.toFixed(2));
        $('#hidSumFrom').val(sAll.toFixed(2));
    });


    $("form").validate({
        rules:{
            transactionSumma:{
                required: true,
                regexp: '[\\d+|\\d+.\\d+]'
            },
            newLogin:{
                required: true,
                regexp: '^[a-z0-9_-]{3,16}$'
            },
            newPassword:{
                required: true,
                regexp: '^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,12}$'
            },
            minSum:{
                required: true,
                regexp: '[\\d+|\\d+.\\d+]'
            },
            telephone:{
                required: true,
                regexp: '^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$'
            },
            postNumber:{
                required: true,
                minlength: 13
            },
            orderNumber:{
                required: true,
                regexp: '\\d+'
            },
            violateNumber:{
                required: true,
                regexp: '\\d{11,11}'
            },
            contractNumber:{
                required: true,
            },
            documentNumber:{
                required: true,
            }
        },
        messages:{
            transactionSumma:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            newLogin:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            newPassword:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            minSum:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            telephone:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            postNumber:{
                required: "The field is required!",
                minlength: 'The completed field does not meet the requirements!'
            },
            orderNumber:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            violateNumber:{
                required: "The field is required!",
                regexp: 'The completed field does not meet the requirements!'
            },
            contractNumber:{
                required: "The field is required!",
            },
            documentNumber:{
                required: "The field is required!",
            }
        },
        errorElement: "div",
        errorPlacement: function(error, element) {
            element.after(error);
        },
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