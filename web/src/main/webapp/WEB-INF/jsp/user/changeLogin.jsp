<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Изменение логина</title>
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
    <h1>Изменение логина</h1>
    <form action="${pageContext.request.contextPath}/user/change/login" method="post">
        <table style="width:33%; margin-left:30px;">
            <tr>
                <td class="label">Текущий логин:</td>
                <td>
                    <input type="text" id="currentLogin" name="currentLogin" class="form" style="text-align: right;">
                    <c:if test="${errorCurrentLogin ne null}">
                        <p style="color: red">${errorCurrentLogin}</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="label">Новый логин:</td>
                <td>
                    <input type="text" id="newLogin" name="newLogin" class="form" style="text-align: right;">
                    <c:if test="${errorNewLogin ne null}">
                        <p style="color: red">${errorNewLogin}</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="label">Подтверждение логина:</td>
                <td><input type="text" id="proofLogin" name="proofLogin" class="form" style="text-align: right;">
                    <c:if test="${errorProofLogin ne null}">
                        <p style="color: red">${errorProofLogin}</p>
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