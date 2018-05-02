$().ready(function(){

    $("#byn").val($("#usd").val()*$("#costBYN"));
    // $("#usd").val();
    // $("#eur").val();

    $("#achat").click(function () {
        $("#achat").css({"text-decoration": "none"});
        $("#vente").css({"text-decoration":"underline"});
    });

    $("#vente").click(function () {
        $("#vente").css({"text-decoration": "none"});
        $("#achat").css({"text-decoration":"underline"});
    });



});