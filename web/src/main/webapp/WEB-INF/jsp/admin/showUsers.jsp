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
    <h1>Пользователи</h1>
    <table style="width:70%; margin-top:20px; color:#777777; border-collapse: collapse; border: 1px solid #d8dcdf;">
        <thead style="background-color: #f0f5f8; border: 1px solid #d8dcdf; ">
        <tr>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                ФИО пользователя
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Кол-во текущих счетов
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Кол-во кредитных счетов
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Кол-во депозитных счетов
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Блокировка
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <form action="${pageContext.request.contextPath}/admin/user/show" method="post">
                <input type="hidden" value="${user.username}" name="username">
                <input type="hidden" value="${user.status}" name="status">
                <tr>
                    <td>${user.surname} ${user.name} ${user.patronymic}</td>
                    <td>${user.numberAccount}</td>
                    <td>${user.numberCredit}</td>
                    <td>${user.numberDeposit}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.status=='UNLOCK'}">
                                <button style='width: 30px; height: 30px;margin-left: 40px; border: none; background: white url("${pageContext.request.contextPath}/resources/images/none_block.png");'></button>
                            </c:when>
                            <c:otherwise>
                                <button style='width: 30px; height: 30px;margin-left: 40px; border: none; background: white url("${pageContext.request.contextPath}/resources/images/block.png");'></button>
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
</html>