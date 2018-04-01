<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css">
    <style>
        @font-face {
            font-family: Theano Didot;
            src: url("${pageContext.request.contextPath}/resources/fonts/Theano Didot.ttf");
        }
    </style>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>

<div class="header">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/resources/images/Logo.png" width="200" height="95">
    </div>
    <div class="welcome">
        <h1 align="right">Добро пожаловать, ${sessionScope.fullName}</h1>
        <a href="#">Выйти</a>
    </div>
</div>

<div class="menu">
    <ul id="nav">
        <li>
            <a href="${pageContext.request.contextPath}/">Главная</a>
        </li>
        <li>
            <a href="#">Мои счета</a>
            <ul>
                <li><a href="#">Открыть счёт</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Мои кредиты</a>
            <ul>
                <li><a href="#">Оформить кредит</a></li>
                <li><a href="#">Погасить кредит</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Мои депозиты</a>
            <ul>
                <li><a href="#">Открыть депозит</a></li>
                <li><a href="#">Подобрать депозит</a></li>
                <li><a href="#">Пополнить депозит</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Переводы</a>
            <ul>
                <li><a href="#">Перевод между своими счетами</a></li>
                <li><a href="#">Обмен валют</a></li>
                <li><a href="#">Перевод денег другому клиенту</a></li>
                <li><a href="#">История переводов</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Платежи</a>
            <ul>
                <li><a href="#">ЕРИП</a></li>
                <li><a href="#">История платежей</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Мои расходы</a>
            <ul>
                <li><a href="#">Диаграмма</a></li>
                <li><a href="#">График</a></li>
                <li><a href="#">По категории платежей</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Настройки</a>
            <ul>
                <li><a href="#">Лимиты по картам</a></li>
                <li><a href="#">Смена логина</a></li>
                <li><a href="#">Смена пароля</a></li>
            </ul>
        </li>
    </ul>

</div>

<div class="main">
    <div class="account">
        <table class="accountTable">
            <thead>
            <tr><td class="pAccount">Счет</td><td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a href="#">Открыть</a></td></tr>
            </thead>
        </table>
    </div>
    <div class="change">
        <table class="changeTable">
            <thead>
            <tr><td class="pAccount">Обмен валют</td><td class="pResidue"><a href="#">Покупка</a>/<a href="#">Продажа</a></td></tr>
            </thead>
            <tbody>
            <tr><td><input type="number" min="0" value="0"></td><td><img src="${pageContext.request.contextPath}/resources/images/belarus.png"><label>BYN</label></td></tr>
            <tr><td><input type="number" min="0" value="0"></td><td><img src="${pageContext.request.contextPath}/resources/images/united-states.png"><label>USD</label></td></tr>
            <tr><td><input type="number" min="0" value="0"></td><td><img src="${pageContext.request.contextPath}/resources/images/russian-federation.png"><label>RUB</label></td></tr>
            <tr><td><input type="number" min="0" value="0"></td><td><img src="${pageContext.request.contextPath}/resources/images/flag-of-europ.png"><label>EUR</label></td></tr>
            </tbody>
        </table>
    </div>
</div>

<div class="info">
    <div class="loans">
        <table class="loansTable">
            <thead>
            <tr><td class="pAccount">Кредит</td><td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a href="#">Оформить</a></td></tr>
            </thead>
        </table>
    </div>
    <div class="deposit">
        <table class="depositTable">
            <thead>
            <tr><td class="pAccount">Депозит</td><td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a href="#">Открыть</a></td></tr>
            </thead>
        </table>
    </div>
</div>

<div class="footer"></div>

</body>
</html>
