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
<h1>Обмен валют</h1>
<form>
    <table style="width:35%; margin-left:30px;">
        <tr>
            <td class="label">Со счета:</td>
            <td>
                <select id="selectFromAccount" class="form" style="width:250px;">
                    <option value="BYN">65165165165316</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="label">На счет:</td>
            <td>
                <select id="selectToAccount" class="form" style="width:250px;">
                    <option value="BYN">65165165165316</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="label">Сумма перевода:</td>
            <td><input type="text" id="summa" class="form" style="text-align: right;"><br></td>
        </tr>
        <tr>
            <td class="label">Комиссия:</td>
            <td><input type="text" id="comission" class="form" disabled style="text-align: right;"><br></td>
        </tr>
        <tr>
            <td class="label">Сумма зачисления:</td>
            <td><input type="text" id="allSumma" class="form" disabled style="text-align: right;"><br></td>
        </tr>
        <tr>
            <td><input type="submit" value="Обмен"></td>
        </tr>
    </table>
</form>

</body>
</html>