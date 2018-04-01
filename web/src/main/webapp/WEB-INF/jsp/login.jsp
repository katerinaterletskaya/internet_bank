<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация | Log in</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?ver=123" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/authorization.css?ver=122" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/authorization.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
</head>
<body>
<%@ include file="static/authorization.jsp" %>
    <form action="login" method="post" class="right-section-form" onsubmit="return isValid();">
        <div class="clearfix">
            <input type="email" autocomplete="off" name="username" id="login" class="form" placeholder="Логин">
        </div>
        <div class="clearfix">
            <input type="password" autocomplete="off" name="password" id="password" class="form" placeholder="Пароль">
        </div>
        <div class="clearfix">
            <input type="submit" value="Войти">
        </div>
    </form>
</body>
</html>
