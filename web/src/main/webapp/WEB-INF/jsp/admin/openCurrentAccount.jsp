<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Заявкина открытие текущего счета</title>
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
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                ФИО пользователя
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Номер паспорта
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Валюта
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Статус открытия
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Действие
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestList}" var="requestItem">
            <form action="${pageContext.request.contextPath}/admin/account/request" method="post">
                <input type="hidden" name="currency" value="${requestItem.currency}"/>
                <input type="hidden" name="passport" value="${requestItem.user.passport}"/>
                <tr>
                    <td>${requestItem.user.surname} ${requestItem.user.name} ${requestItem.user.patronymic}</td>
                    <td>${requestItem.user.passport}</td>
                    <td>${requestItem.currency}</td>
                    <td>
                        <c:choose>
                            <c:when test="${requestItem.status == true}">
                                Открыт
                            </c:when>
                            <c:otherwise>
                                В ожидании
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${requestItem.status==true}">
                                <button style='width: 30px; height: 30px;margin-left: 40px; border: none; background: white url("${pageContext.request.contextPath}/resources/images/galochka.png");' disabled></button>
                            </c:when>
                            <c:otherwise>
                                <button style='width: 30px; height: 30px;margin-left: 40px; border: none; background: white url("${pageContext.request.contextPath}/resources/images/none.png");' type="submit"></button>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
