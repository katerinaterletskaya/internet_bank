$().ready(function(){

    $("#registrationUser").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/registrationUser.html");
    });

    $("#addDeposit").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/addDeposit.html");
    });

    $("#addLoan").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/addLoan.html");
    });
    $("#changeKurs").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/changeKurs.html");
    });
    $("#openAccount").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/openAccount.html");
    });
    $("#openDeposit").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/openDeposit.html");
    });
    $("#openLoan").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/openLoan.html");
    });
    $("#plusAccount").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/plusAccount.html");
    });
    $("#searchUser").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/searchUser.html");
    });
    $("#showUsers").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/showUsers.html");
    });
    $("#viewDeposit").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/viewDeposit.html");
    });
    $("#viewLoan").click(function () {
        $(".content").empty();
        $(".content").load("../html/admin/viewLoan.html");
    });

});