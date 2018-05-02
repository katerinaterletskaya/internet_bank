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
        <a href="${pageContext.request.contextPath}/logout">Выйти</a>
    </div>
</div>

<div class="menu">
    <ul id="nav">
        <li>
            <a href="${pageContext.request.contextPath}/">Главная</a>
        </li>
        <li>
            <a href="#" id="myAccount">Мои счета</a>
            <ul>
                <li><a href="#" id="openAccount">Открыть счёт</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="myLoans">Мои кредиты</a>
            <ul>
                <li><a href="#" id="openLoans">Оформить кредит</a></li>
                <li><a href="#" id="repayLoans">Погасить кредит</a></li>
            </ul>
        </li>
        <li>
            <a href="#" id="myDeposit">Мои депозиты</a>
            <ul>
                <li><a href="#" id="openDeposit">Открыть депозит</a></li>
                <li><a href="#" id="chooseDeposit">Подобрать депозит</a></li>
                <li><a href="#" id="plusDeposit">Пополнить депозит</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Переводы</a>
            <ul>
                <li><a href="#" id="transactionMyAccount">Перевод между своими счетами</a></li>
                <li><a href="#" id="changeCurrency">Обмен валют</a></li>
                <li><a href="#" id="transactionOtherClient">Перевод денег другому клиенту</a></li>
                <li><a href="#" id="transactionHistory">История переводов</a></li>
            </ul>
        </li>
        <li>
            <a href="#">Платежи</a>
            <ul>
                <li><a href="#">ЕРИП</a></li>
                <li><a href="#" id="paymentHistory">История платежей</a></li>
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
                <li><a href="#" id="changeLogin">Смена логина</a></li>
                <li><a href="#" id="changePassword">Смена пароля</a></li>
            </ul>
        </li>
    </ul>

</div>

<div class="content">

<div class="main">
    <div class="account">
        <table class="accountTable">
            <thead>
            <tr>
                <td class="pAccount">Счет</td>
                <td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a
                        href="#">Открыть</a></td>
            </tr>
            </thead>
        </table>
    </div>
    <div class="change">
        <table class="changeTable">
            <thead>
            <tr><td class="pAccount">Обмен валют</td><td class="pResidue"><a href="#" id="achat">Покупка</a>/<a href="#" id="vente">Продажа</a></td></tr>
            </thead>

            <tbody>
            <c:forEach items="currencyList" var="currency">
            <tr>
                <td><input type="number" min="0" value="currency."></td>
                <td><img
                        src="${pageContext.request.contextPath}/resources/images/${currency.currency}.png"><label>${currency.currency}</label>
                </td>
            </tr>
                <%--<tr>--%>
                <%--<td><input type="number" min="0" value="0"></td>--%>
                <%--<td><img src="${pageContext.request.contextPath}/resources/images/BYN.png"><label>BYN</label>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td><input type="number" min="0" value="0"></td>--%>
                <%--<td><img--%>
                <%--src="${pageContext.request.contextPath}/resources/images/USD.png"><label>USD</label>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td><input type="number" min="0" value="0"></td>--%>
                <%--<td><img--%>
                <%--src="${pageContext.request.contextPath}/resources/images/RUB.png"><label>RUB</label>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td><input type="number" min="0" value="0"></td>--%>
                <%--<td><img--%>
                <%--src="${pageContext.request.contextPath}/resources/images/EUR.png"><label>EUR</label>--%>
                <%--</td>--%>
                <%--</tr>--%>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="info">
    <div class="loans">
        <table class="loansTable">
            <thead>
            <tr>
                <td class="pAccount">Кредит</td>
                <td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a
                        href="#">Оформить</a></td>
            </tr>
            </thead>
        </table>
    </div>
    <div class="deposit">
        <table class="depositTable">
            <thead>
            <tr>
                <td class="pAccount">Депозит</td>
                <td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a
                        href="#">Открыть</a></td>
            </tr>
            </thead>
        </table>
    </div>
</div>
</div>

<div class="footer">
        <span style="text-align: right; width:100%;">Лицензия на осуществление банковской деятельности НБРБ №0005 от 22.07.2018 г.<br>
            Интернет-банк "Belarussian Commercial Bank" Copyright &#169; 2017-2018</span>
</div>

</body>
</html>
