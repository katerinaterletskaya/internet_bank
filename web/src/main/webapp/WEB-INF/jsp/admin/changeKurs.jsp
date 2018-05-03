<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
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
<%@ include file="adminHeader.jsp" %>
<div class="content">
    <h1>Изменить курс валют</h1>
    <form>
        <table style="width:37%; margin-left:30px;">
            <tr>
                <td class="label">USD:</td>
                <td><input type="text" id="costUSD" class="form" style="text-align: right;"  placeholder="Покупка"></td>
                <td><input type="text" id="saleUSD" class="form" style="text-align: right;"  placeholder="Продажа"></td>
            </tr>
            <tr>
                <td class="label">EUR:</td>
                <td><input type="text" id="costEUR" class="form" style="text-align: right;"  placeholder="Покупка"></td>
                <td><input type="text" id="saleEUR" class="form" style="text-align: right;"  placeholder="Продажа"></td>
            </tr>
            <tr>
                <td class="label">RUB:</td>
                <td><input type="text" id="costRUB" class="form" style="text-align: right; "  placeholder="Покупка"></td>
                <td><input type="text" id="saleRUB" class="form" style="text-align: right; "  placeholder="Продажа"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Изменить"></td>
            </tr>
        </table>
    </form>

</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>