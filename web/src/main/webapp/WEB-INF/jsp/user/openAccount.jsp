<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обмен валют</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/resources/js/authorization.js"></script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="userHeader.jsp" %>
<div class="content">
<h1>Открыть счет</h1>
<form action="${pageContext.request.contextPath}/user/account/new" method="post">
    <table style="width:25%; margin-left:30px;">
        <tr>
            <td class="label">Валюта:</td>
            <td><select id="selectCurrency" name="currency" class="form">
                <option value="BYN">BYN</option>
                <option value="USD">USD</option>
                <option value="EUR">EUR</option>
                <option value="RUB">RUB</option>
            </select></td>
        </tr>
        <tr>
            <td class="label">Имя счета:</td>
            <td><input type="text" id="nameAccount" class="form"><br></td>
        </tr>
        <tr>
            <td><input type="submit" value="Открыть"></td>
        </tr>
    </table>
</form>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>