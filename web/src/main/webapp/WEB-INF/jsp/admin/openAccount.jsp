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
    <h1>Открыть текущий счет</h1>
    <form action="${pageContext.request.contextPath}/admin/account/open" method="post">
        <table style="width:50%; margin-left:30px;">
            <tr>
                <td class="label">Номер паспорта клиента:</td>
                <td><input type="text" id="passportNumber" name="passport" class="form"><br></td>
            </tr>
            <tr >
                <td class="label" style="vertical-align: middle; padding-top: 10px;">Валюта счета:</td>
                <td style="padding-top: 10px;">
                    <div class="radio-group" style="vertical-align: bottom;">
                        <input type="radio" id="option-one" name="selector" value="BYN"><label for="option-one" onclick="$('#chooseCurrency').val('BYN')">BYN</label><input type="radio" id="option-two" name="selector" value="USD"><label for="option-two" onclick="$('#chooseCurrency').val('USD')">USD</label><input type="radio" id="option-three" value="EUR" name="selector"><label onclick="$('#chooseCurrency').val('EUR')" for="option-three">EUR</label><input type="radio" value=RUB" id="option-fourth" name="selector"><label onclick="$('#chooseCurrency').val('RUB')" for="option-fourth">RUB</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="label">Начальная сумма:</td>
                <td>
                    <input type="text" id="summa" class="form" style="text-align: right;" value="0"> &nbsp; &nbsp;%
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Открыть"></td>
            </tr>
        </table>
    </form>

</div>
<input type="text" hidden style="border: none;" id="chooseCurrency">

<%@ include file="../user/userFooter.jsp" %>
</body>
</html>