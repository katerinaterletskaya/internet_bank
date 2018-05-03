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
    <h1>Регистрация пользователя</h1>
    <form>
        <table style="width:33%; margin-left:30px;">
            <tr>
                <td class="label">Фамилия:</td>
                <td>
                    <input type="text" id="surname" class="form" >
                </td>
            </tr>
            <tr>
                <td class="label">Имя:</td>
                <td>
                    <input type="text" id="name" class="form" >
                </td>
            </tr>
            <tr>
                <td class="label">Отчество:</td>
                <td><input type="text" id="patronomyc" class="form" ><br></td>
            </tr>
            <tr>
                <td class="label">Номер паспорта:</td>
                <td>
                    <input type="text" id="passportNumber" class="form" >
                </td>
            </tr>
            <tr>
                <td class="label">Логин:</td>
                <td>
                    <input type="text" id="login" class="form" >
                </td>
            </tr>
            <tr>
                <td class="label">Пароль:</td>
                <td><input type="text" id="password" class="form"><br></td>
            </tr>
            <tr>
                <td><input type="submit" value="Регистрация"></td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>