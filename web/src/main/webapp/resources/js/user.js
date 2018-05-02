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



});