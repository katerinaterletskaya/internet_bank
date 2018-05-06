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
    <h1>Заявки на открытие текущего счета</h1>
    <table style="width:70%; margin-top:20px; color:#777777; border-collapse: collapse; border: 1px solid #d8dcdf;">
        <thead style="background-color: #f0f5f8; border: 1px solid #d8dcdf; ">
        <tr>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">ФИО пользователя</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Мобильный телефон</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Валюта</th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">Статус открытия</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>jnkjsbg k kejnrfk k</td>
            <td>4памвм</td>
            <td><button style="width: 30px; height: 30px;margin-left: 40px; border: none; background-color: white;" onclick="alert('djksjd');"></button></td>
        </tr>
        </tbody>

    </table>

    <form>
        <table style="width:50%; margin-left:30px; margin-top: 30px;">

            <tr>
                <td class="label">Введите номер счета:</td>
                <td><input type="text" id="accountNumber" class="form"><br></td>
            </tr>
            <tr>
                <td><input type="submit" value="Открыть"></td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
