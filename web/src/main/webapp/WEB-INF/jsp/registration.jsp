<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация | Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?ver=123" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/authorization.css?ver=122"
          type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/authorization.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
</head>
<body>
<%@ include file="static/authorization.jsp" %>
<form action="/register" method="post" class="right-section-form" onsubmit="return isValid();">
    <p> Укажите ваши личные данные, номер паспорта, указанный в
        паспорте гражданина Республики Беларусь или в виде на жительство в Республике Беларусь, а также
        ваш логин-email и пароль.</p>
    <div class="clearfix">
        <input type="text" autocomplete="off" name="surname" id="surname" class="form" placeholder="Фамилия">
    </div>
    <div class="clearfix">
        <input type="text" autocomplete="off" name="name" id="name" class="form" placeholder="Имя">
    </div>
    <div class="clearfix">
        <input type="text" autocomplete="off" name="patronymic" id="patronymic" class="form" placeholder="Отчество">
    </div>
    <div class="clearfix">
        <input type="text" autocomplete="off" name="passport" id="passport" class="form" placeholder="№ паспорта">
    </div>
    <div class="clearfix">
        <input type="email" autocomplete="off" name="username" id="login" class="form" placeholder="Логин">
        <c:if test="${usernameError ne null}">
            <c:out value="${usernameError}"/>
        </c:if>
    </div>
    <div class="clearfix">
        <input type="password" autocomplete="off" name="password" id="password" class="form" placeholder="Пароль">
    </div>
    <div class="clearfix">
        <input type="submit" value="Регистрация">
    </div>
</form>
</body>
</html>
