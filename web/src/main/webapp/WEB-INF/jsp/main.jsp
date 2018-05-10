
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Belarusian Commercial Bank</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<div class="nav">
    <figure>
        <img src="${pageContext.request.contextPath}/resources/images/Logo.png" height="72" width="150">
    </figure>
    <ul id="nav" style="margin-left: 150px;">
        <li>
            <a href="${pageContext.request.contextPath}/login" id="online">Банк онлайн</a>
        </li>
    </ul>
</div>

<div class="slider">
    <img src="${pageContext.request.contextPath}/resources/images/home_image.jpg" width="100%">
</div>

<div class="plus">
    <img src="${pageContext.request.contextPath}/resources/images/pluses.jpg" width="100%">
</div>

<div class="otsyv">
    <img src="${pageContext.request.contextPath}/resources/images/otzovy.jpg" width="100%">
</div>
</body>
</html>
