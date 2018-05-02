$().ready(function(){

    $("#achat").click(function () {
        $("#achat").css({"text-decoration": "none"});
        $("#vente").css({"text-decoration":"underline"});
    });

    $("#vente").click(function () {
        $("#vente").css({"text-decoration": "none"});
        $("#achat").css({"text-decoration":"underline"});
    });

    $("#openAccount").click(function () {
        $(".content").empty();
        $(".content").load("../html/openAccount.html");
    });

    $("#openLoans").click(function () {
        $(".content").empty();
        $(".content").load("../html/openLoans.html");
    });

    $("#repayLoans").click(function () {
        $(".content").empty();
        $(".content").load("../html/repayLoans.html");
    });

    $("#openDeposit").click(function () {
        $(".content").empty();
        $(".content").load("../html/openDeposit.html");
    });

    $("#chooseDeposit").click(function () {
        $(".content").empty();
        $(".content").load("../html/chooseDeposit.html");
    });

    $("#plusDeposit").click(function () {
        $(".content").empty();
        $(".content").load("../html/plusDeposit.html");
    });


    $("#transactionMyAccount").click(function () {
        $(".content").empty();
        $(".content").load("../html/transactionMyAccount.html");
    });

    $("#changeCurrency").click(function () {
        $(".content").empty();
        $(".content").load("../html/changeCurrency.html");
    });

    $("#transactionOtherClient").click(function () {
        $(".content").empty();
        $(".content").load("../html/transactionOtherClient.html");
    });

    $("#transactionHistory").click(function () {
        $(".content").empty();
        $(".content").load("../html/transactionHistory.html");
    });

    $("#changeLogin").click(function () {
        $(".content").empty();
        $(".content").load("../html/changeLogin.html");
    });

    $("#changePassword").click(function () {
        $(".content").empty();
        $(".content").load("../html/changePassword.html");
    });
    $("#paymentHistory").click(function () {
        $(".content").empty();
        $(".content").load("../html/paymentHistory.html");
    });

});