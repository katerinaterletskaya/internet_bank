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
                        <c:choose>
                            <c:when test="${payment.category=='Билеты'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/ticket/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:when test="${payment.category=='Интернет, Телевидение'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/internet/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:when test="${payment.category=='Интернет-магазины, Сервисы'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/shop/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:when test="${payment.category=='МВД'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP//${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:when test="${payment.category=='Мобильная связь'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/mobile/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:when test="${payment.category=='СМИ'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/massmedia/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:when test="${payment.category=='Таможенные платежи'}">
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/custom/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/user/payment/ERIP/legal/${payment.id}"><c:out
                                        value="${payment.name}"/></a>
                            </c:otherwise>
                        </c:choose>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>