<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Изменение пароля</title>
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
<%@ include file="userHeader.jsp" %>
<div class="content">
    <h1>Изменение пароля</h1>
    <form action="${pageContext.request.contextPath}/user/change/password" method="post">
        <table style="width:33%; margin-left:30px;">
            <tr>
                <td class="label">Текущий пароль:</td>
                <td>
                    <input type="text" id="currentPassword" name="currentPassword" class="form"
                           style="text-align: right;">
                    <c:if test="${errorCurrentPassword ne null}">
                        <p style="color: red">${errorCurrentPassword}</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="label">Новый пароль:</td>
                <td>
                    <input type="password" id="newPassword" name="newPassword" class="form" style="text-align: right;">
                </td>
            </tr>
            <tr>
                <td class="label">Подтверждение пароля:</td>
                <td><input type="password" id="proofPassword" name="proofPassword" class="form" style="text-align: right;">
                    <c:if test="${errorNewPassword ne null}">
                        <p style="color: red">${errorNewPassword}</p>
                    </c:if>
                    <br>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Изменить"></td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>