<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Подобрать депозит</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/resources/js/authorization.js"></script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../user/userHeader.jsp" %>
<div class="content" style="border: 2px solid rgba(0,0,0,.3); border-radius: 4px;">
    <table style="width:29%; margin-left:50px; margin-bottom: 15px; margin-top:50px;">
        <tr>
            <td class="label" style="font-size: 18px;"><p style="text-align: justify;">Введите номер заказа, полученный на сайте издания.</p></td>
        </tr>
    </table>
    <form>
        <table style="width:29%; margin-left:50px; margin-bottom: 50px;">
            <tr>
                <td class="label">Номер заказа:</td>
                <td><input type="text" id="number" name="orderNumber" class="form"><br></td>
            </tr>
            <tr>
                <td><input type="submit" value="Оплатить"></td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>