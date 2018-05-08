<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
    <%--<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>--%>
    <style>
        @font-face {
            font-family: Theano Didot;
            src: url("${pageContext.request.contextPath}/resources/fonts/Theano Didot.ttf");
        }
    </style>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>

<div class="header">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/resources/images/Logo.png" width="200" height="95">
    </div>
    <div class="welcome">

        <h1 align="right">Добро пожаловать, администратор</h1>
        <a href="${pageContext.request.contextPath}/logout">Выйти</a>
    </div>
</div>

<div class="menu">
    <ul id="nav">
        <li>
            <a href="${pageContext.request.contextPath}/admin/main">Главная</a>
        </li>
        <li>
            <a href="#" id="users">Пользователи</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/user/new" id="registrationUser">Зарегистрировать пользователя</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/user/show" id="showUsers">Просмотр всех пользователей</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="loans">Кредиты</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/loan/new" id="addLoan">Добавить новый кредит</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/loan/open" id="openLoan">Открыть кредит ФЛ</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/loan/request" id="viewLoan">Просмотр заявок на кредиты</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="deposit">Депозиты</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/deposit/open" id="openDeposit">Открыть депозит ФЛ</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deposit/new" id="addDeposit">Добавить новый депозит</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deposit/request" id="viewDeposit">Просмотр заявок на депозиты</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="account">Счета</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/account/open" id="openAccount">Открыть счет ФЛ</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/account/plus" id="plusAccount">Пополнить счет ФЛ</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/account/request" id="openCurrentAccount">Просмотр заявок на открытие текущего счета</a></li>
            </ul>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/kurs" id="changeKurs">Изменить курс валют</a>
        </li>
    </ul>

</div>

</body>
</html>