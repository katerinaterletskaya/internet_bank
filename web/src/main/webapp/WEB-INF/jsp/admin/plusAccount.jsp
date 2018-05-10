<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Пополнить счет клиенту</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>

    <style>
        @font-face {
            font-family: Theano Didot;
            src: url("${pageContext.request.contextPath}/resources/fonts/Theano Didot.ttf");
        }

    </style>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<%@ include file="adminHeader.jsp" %>
<div class="content">
    <h1>Пополнить счет клиенту</h1>
    <form action="${pageContext.request.contextPath}/admin/account/plus" method="post">
        <table style="width:37%; margin-left:30px;">
            <tr>
                <td class="label">Номер паспорта:</td>
                <td><input type="text" id="passportNumber" name="passport" class="form"></td>
                <td><input type="submit" value="Поиск счетов"></td>
            </tr>
        </table>
    </form>
    <c:choose>
        <c:when test="${error ne null}">
            <h3 style="color: red;"><c:out value="${error}"/></h3>
        </c:when>
        <c:otherwise>
            <c:if test="${numbers ne null}">
                <form action="${pageContext.request.contextPath}/admin/account/plus/sum" method="post" style=" margin-top: 15px;" id="accountForm">
                    <table style="width:45%; margin-left:30px;">
                        <tr>
                            <td class="label">Счет:</td>
                            <td>
                                <select id="selectAccount" class="form" name="accountNumber" style="width:250px;">
                                    <c:forEach items="${numbers}" var="number">
                                        <option>${number}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <table style="width:37%; margin-left:30px;">
                        <tr>
                            <td class="label">Сумма:</td>
                            <td><input type="text" id="summa" name="minSum" class="form" style="text-align: right;"></td>
                        </tr>
                        <tr>
                            <td class="label">Комиссия:</td>
                            <td><input type="text" id="comission" class="form" disabled style="text-align: right;"></td>
                        </tr>
                        <tr>
                            <td class="label">Общая сумма:</td>
                            <td><input type="text" id="allSumma" class="form" disabled style="text-align: right;"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Пополнить"></td>
                        </tr>
                    </table>
                    <input type="hidden" name="number" id="toAccount">
                </form>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>
<%@ include file="../user/userFooter.jsp" %>
<script>
    $('#summa').change(function () {
        $('#comission').val(($('#summa').val()*0.1).toFixed(2));
        var com = $('#comission').val();
        var s = $('#summa').val()
        var sAll= parseFloat(com)+parseFloat(s);
        $('#allSumma').val(sAll.toFixed(2));
    });
</script>
</body>
</html>
