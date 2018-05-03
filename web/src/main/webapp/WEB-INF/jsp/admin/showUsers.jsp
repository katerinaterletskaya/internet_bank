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
<%@ include file="adminHeader.jsp" %>
<div class="content">
    <h1>Пользователи</h1>
    <table style="width:70%; margin-top:20px; color:#777777; border-collapse: collapse; border: 1px solid #d8dcdf;">
        <thead style="background-color: #f0f5f8; border: 1px solid #d8dcdf; ">
        <tr>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">ФИО пользователя</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Кол-во текущих счетов</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Кол-во кредитных счетов</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Кол-во депозитных счетов</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Блокировка</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>jnkjsbg k kejnrfk k</td>
            <td>4</td>
            <td>3</td>
            <td>2</td>

            <td><button style="width: 30px; height: 30px;margin-left: 40px; border: none; background-color: white;" onclick="alert('djksjd');" c></button></td>
        </tr>
        </tbody>
    </table>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>