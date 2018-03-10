$().ready(function(){

    $("#choose").empty();
    $("#choose").load("../../WEB-INF/jsp/static/login.jsp");
    $("#log_in").css("border-bottom", "none");

    $("#registration").click(function () {
        $("#choose").empty();
        $("#choose").load("../static/registration.jsp");
        $("#log_in").css("border-bottom", "1.7px dotted rgba(0,0,0,.3)");
        $("#registration").css("border-bottom", "none");
    });

    $("#log_in").click(function () {
        $("#choose").empty();
        $("#choose").load("../static/login.jsp");
        $("#log_in").css("border-bottom", "none");
        $("#registration").css("border-bottom", "1.7px dotted rgba(0,0,0,.3)");
    });

    $("#main").click(function () {
        window.open("../static/index.html", "_self");
    });
});