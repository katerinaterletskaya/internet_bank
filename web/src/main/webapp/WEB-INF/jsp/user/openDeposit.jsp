<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Открыть депозит</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="userHeader.jsp" %>
<div class="content">
<table>
    <tr>
        <td><img src="${pageContext.request.contextPath}/resources/images/button-info-icon.mXvdc.png" ></td>
        <td><h1 style="text-align: justify;">Оформление депозита происходит непосредственно в любом отделении нашего банка. Оставьте пожалуйста свой номер телефона, с вами свяжется наш сотрудник и согласует удобное для вас время!</h1></td>
    </tr>
</table>
<form action="${pageContext.request.contextPath}/user/deposit/new" method="post">
    <table style="width:37%; margin-left:30px;">
        <tr>
            <td class="label">Ваш номер телефона:</td>
            <td><input type="text" id="telephoneNumber" name="telephone" class="form" style="width: 200px;"><br></td>
        </tr>
        <tr>
            <td><input type="submit" value="Отправить"></td>
        </tr>
    </table>
</form>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>