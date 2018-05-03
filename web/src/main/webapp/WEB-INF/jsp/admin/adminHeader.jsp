<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
    <script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
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
        <a href="#">Выйти</a>
    </div>
</div>

<div class="menu">
    <ul id="nav">
        <li>
            <a href="#">Главная</a>
        </li>
        <li>
            <a href="#" id="users">Пользователи</a>
            <ul>
                <li><a href="#" id="registrationUser">Зарегистрировать пользователя</a></li>
                <li><a href="#" id="showUsers">Просмотр всех пользователей</a></li>
                <li><a href="#" id="searchUser">Поиск регистрационных данных</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="loans">Кредиты</a>
            <ul>
                <li><a href="#" id="addLoan">Добавить новый кредит</a></li>
                <li><a href="#" id="openLoan">Открыть кредит ФЛ</a></li>
                <li><a href="#" id="viewLoan">Просмотр заявок на кредиты</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="deposit">Депозиты</a>
            <ul>
                <li><a href="#" id="openDeposit">Открыть депозит ФЛ</a></li>
                <li><a href="#" id="addDeposit">Добавить новый депозит</a></li>
                <li><a href="#" id="viewDeposit">Просмотр заявок на депозиты</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="account">Счета</a>
            <ul>
                <li><a href="#" id="openAccount">Открыть счет ФЛ</a></li>
                <li><a href="#" id="plusAccount">Пополнить счет ФЛ</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="changeKurs">Изменить курс валют</a>
        </li>
    </ul>

</div>

</body>
</html>