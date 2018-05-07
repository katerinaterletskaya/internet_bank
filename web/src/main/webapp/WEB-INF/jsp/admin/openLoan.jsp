<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
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
    <h1>Оформление кредита физ. лицу</h1>
    <form action="${pageContext.request.contextPath}/admin/loan/open" method="post">
        <table style="width:37%; margin-left:30px;">
            <tr>
                <td class="label">Номер паспорта:</td>
                <td><input type="text" id="passportNumber" name="passport" class="form"></td>
            </tr>
            <tr>
                <td class="label">Кредит:</td>
                <td>
                    <select id="selectCredit" name="name" class="form" style="width:250px;"
                            onclick="$('#currency').val($('#selectCredit').val()); $('#currency1').val($('#selectCredit').val());">
                        <c:forEach items="${credits}" var="credit">
                            <option value="${credit.currency}">${credit.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="label">Валюта:</td>
                <td><input type="text" id="currency" class="form" disabled><br></td>
            </tr>
            <tr>
                <td class="label">Сумма кредита:</td>
                <td>
                    <input type="text" id="summa" name="minSum" class="form" style="text-align: right;" value="0">
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Открыть"></td>
            </tr>
        </table>
        <input type="hidden" id="currency1" name="currency">
    </form>
</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>