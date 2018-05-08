<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Изменение курса валют</title>
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
    <form action="${pageContext.request.contextPath}/admin/kurs" method="post">
        <table style="width:37%; margin-left:30px; margin-top:50px;">
            <tr>
                <td class="label"></td>
                <td class="label">Покупка</td>
                <td class="label">Продажа</td>
            </tr>
            <c:forEach items="${currencies}" var="currency">
                <tr>
                    <td class="label">${currency.currency}:</td>
                    <td class="label">Покупка<input type="text" id="cost${currency.currency}" name="cost${currency.currency}" class="form" style="text-align: right;"
                                                    placeholder="Покупка" value="${currency.cost}"></td>
                    <td class="label">Продажа><input type="text" id="sale${currency.currency}" name="sale${currency.currency}" class="form" style="text-align: right;"
                                                     placeholder="Продажа" value="${currency.sale}"></td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="submit" value="Изменить">
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>