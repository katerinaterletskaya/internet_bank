<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/authorization.css">
</head>
<body>
<%@ include file="../authorization.jsp" %>
    <form action="/login" method="post" class="right-section-form">
        <div class="clearfix">
            <input type="email" autocomplete="off" name="login" id="login" class="form" placeholder="Логин">
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
