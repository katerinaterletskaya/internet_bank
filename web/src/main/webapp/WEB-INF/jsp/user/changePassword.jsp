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
<h1>Изменение пароля</h1>
<form>
    <table style="width:33%; margin-left:30px;">
        <tr>
            <td class="label">Текущий пароль:</td>
            <td>
                <input type="text" id="currentPassword" class="form" style="text-align: right;">
            </td>
        </tr>
        <tr>
            <td class="label">Новый пароль:</td>
            <td>
                <input type="text" id="newPassword" class="form" style="text-align: right;">
            </td>
        </tr>
        <tr>
            <td class="label">Подтверждение пароля:</td>
            <td><input type="text" id="proofPassword" class="form" style="text-align: right;"><br></td>
        </tr>
        <tr>
            <td><input type="submit" value="Изменить"></td>
        </tr>
    </table>
</form>
</body>
</html>