<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>История переводов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<%@ include file="userHeader.jsp" %>
<div class="content">
    <h1>История переводов</h1><br>
    <form action="${pageContext.request.contextPath}/user/transaction/history" method="post">
        <div>
            <table style="width:32%; margin-left:30px;">
                <tr>
                    <td class="label">По счету:</td>
                    <td>
                        <select id="selectFromAccount" name="accountNumber" class="form" style="width:250px;">
                            <c:forEach items="${accounts}" var="account">
                                <option>${account.number}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
        <table style="width:60%; margin-left:30px;">
            <tr>
                <td class="label">За период с:</td>
                <td>
                    <input type="date" id="dateFrom" name="dateFrom" class="form">
                </td>
                <td class="label">по:</td>
                <td>
                    <input type="date" id="dateTo" name="dateTo" class="form">
                </td>
                <td class="label">или за</td>
                <td>
                    <a href="#" onclick="$('#day').val('today');">сегодня</a>
                </td>
                <td>
                    <a href="#" onclick="$('#day').val('month');">месяц</a>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Показать"></td>
            </tr>
        </table>
        <input type="hidden" name="day" id="day">
    </form>
    <br> <br>
    <table style="width:100%; margin-left:30px; color:#777777; border-collapse: collapse; border: 1px solid #d8dcdf;">
        <thead style="background-color: #f0f5f8; border: 1px solid #d8dcdf; ">
        <tr>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Дата перевода
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Фамилия получателя
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                На счет
            </th>
            <th style="text-align: center; font-size: 14px; font-family: Arial, sans-serif; letter-spacing: 2px; word-spacing: 3px; padding: 8px;">
                Итоговая сумма
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
                <td>${transaction.date}</td>
                <td>${transaction.surname}</td>
                <td>${transaction.toAccount}</td>
                <td>${transaction.sum}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>