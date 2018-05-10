<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пополнение депозита</title>
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
    <h1>Пополнение депозита</h1>
    <form action="${pageContext.request.contextPath}/user/deposit/plus" method="post">
        <table style="width:32%; margin-left:30px;">
            <tr>
                <td class="label">Со счета:</td>
                <td>
                    <select id="selectFromAccount" class="form" name="fromAccount" style="width:250px;">
                        <c:forEach items="${accounts}" var="account">
                            <option>${account.number}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <c:if test="${error ne null}">
                <tr>
                    <h3 style="color: red"><c:out value="${error}"/></h3>
                </tr>
            </c:if>
            <tr>
                <td class="label">На счет:</td>
                <td>
                    <select id="selectToAccount" class="form" name="toAccount" style="width:250px;">
                        <c:forEach items="${deposits}" var="deposit">
                            <option>${deposit.number}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="label">Сумма:</td>
                <td><input type="text" id="summa" name="transactionSumma" class="form" style="text-align: right;"><br>
                </td>
            </tr>
            <tr>
                <td class="label">Комиссия:</td>
                <td><input type="text" id="comission" class="form" disabled style="text-align: right;"><br></td>
            </tr>
            <tr>
                <td class="label">Общая сумма:</td>
                <td><input type="text" id="allSumma" class="form" disabled style="text-align: right;"><br>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Оплатить"></td>
            </tr>
        </table>
        <input type="hidden" id="hidSum" name="sum">
    </form>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>