<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css">
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
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
        <h1 align="right">Добро пожаловать, ${sessionScope.fullName}</h1>
    </div>
</div>

<div class="menu">
    <ul id="nav">
        <li>
            <a href="${pageContext.request.contextPath}/user/main">Главная</a>
        </li>
        <li>
            <a href="#" id="myAccount">Мои счета</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/account/new" id="openAccount">Открыть счёт</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="myLoans">Мои кредиты</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/loans/new" id="openLoans">Оформить кредит</a></li>
                <li><a href="${pageContext.request.contextPath}/user/loans/repay" id="repayLoans">Погасить кредит</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="myDeposit">Мои депозиты</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/deposit/new" id="openDeposit">Открыть депозит</a></li>
                <li><a href="${pageContext.request.contextPath}/user/deposit/plus" id="plusDeposit">Пополнить депозит</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Переводы</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/transaction/my" id="transactionMyAccount">Перевод между своими счетами</a></li>
                <li><a href="${pageContext.request.contextPath}/user/transaction/currency" id="changeCurrency">Обмен валют</a></li>
                <li><a href="${pageContext.request.contextPath}/user/transaction/other" id="transactionOtherClient">Перевод денег другому клиенту</a></li>
                <li><a href="${pageContext.request.contextPath}/user/transaction/history" id="transactionHistory">История переводов</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Платежи</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/payment/ERIP">ЕРИП</a></li>
                <li><a href="${pageContext.request.contextPath}/user/payment/history" id="paymentHistory">История платежей</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Мои расходы</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/diagram/chart">Диаграмма</a></li>
                <li><a href="${pageContext.request.contextPath}/user/diagram/line">График</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Настройки</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/change/login" id="changeLogin">Смена логина</a></li>
                <li><a href="${pageContext.request.contextPath}/user/change/password" id="changePassword">Смена пароля</a></li>
            </ul>
        </li>
    </ul>

</div>
</body>
</html>