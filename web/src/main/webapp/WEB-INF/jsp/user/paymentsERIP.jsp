<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Платежи ЕРИП</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<%@ include file="userHeader.jsp" %>
<div class="content">
    <h1>Платежи</h1>
    <form style="margin-top:30px;">
        <table style="width:100%; margin-left:30px; margin-right: 30px;">
            <c:forEach items="${payments}" var="payment" varStatus="1">
                <tr>
                    <td>
                        <a href="#"><c:out value="${payment.name}"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>