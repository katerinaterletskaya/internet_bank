<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вход в Интернет-Банк|Sign in the Internet Bank</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?ver=123" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/authorization.css?ver=122" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/authorization.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
    <div class="nav">
        <figure>
            <img src="${pageContext.request.contextPath}/resources/images/Logo.png" height="72" width="150">
        </figure>

        <ul class="clearfix" style="margin-left: 250px;">

            <li><a href="${pageContext.request.contextPath}/" id="main">Главная</a></li>
        </ul>
    </div>

    <div class="right-section">
        <h1 >Интернет-банк</h1>
        <div class="menu clearfix">
            <div id="log">
                <a href="${pageContext.request.contextPath}/login" id="log_in">Вход</a>
            </div>
            <a href="${pageContext.request.contextPath}/registration" id="registration">Регистрация</a>
        </div>
    </div>
</body>
</html>
