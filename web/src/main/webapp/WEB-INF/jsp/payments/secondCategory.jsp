<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<%@ include file="../user/userHeader.jsp" %>
<div class="content" style="border: 2px solid rgba(0,0,0,.3); border-radius: 4px;">
    <table style="width:35%; margin-left:50px; margin-bottom: 15px; margin-top:50px;">
        <tr>
            <td class="label" style="font-size: 18px;"><p style="text-align: justify;">Введите номер договора с
                компанией</p></td>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/user/payment/ERIP/internet" method="post">
        <table style="width:35%; margin-left:50px; margin-bottom: 50px;">
            <tr>
                <td class="label">Со счета:</td>
                <td>
                    <select id="selectFromAccount" name="account" class="form" style="width:250px;">
                        <c:forEach items="${numbers}" var="number">
                            <option>${number.number}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="label">Номер договора:</td>
                <td><input type="text" id="number" name="contractNumber" class="form"><br></td>
            </tr>
            <tr>
                <td class="label">Сумма:</td>
                <td><input type="text" id="summa" name="sum" class="form" style="text-align: right;"><br></td>
            </tr>
            <tr>
                <td><input type="submit" value="Оплатить"></td>
            </tr>
        </table>
        <input type="hidden" id="payment" name="payment" value="${id}">
    </form>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>