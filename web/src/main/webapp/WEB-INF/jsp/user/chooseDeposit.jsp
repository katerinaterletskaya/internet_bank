<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обмен валют</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <%--<script src="${pageContext.request.contextPath}/resources/js/authorization.js"></script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="userHeader.jsp" %>
<div class="content">
<h1>Подобрать депозит</h1>
<br>
<form style="width: 36%;float: left">
    <table style="margin-left:30px;">
        <tr>
            <td class="label" style="vertical-align: middle;">Валюта:</td>
            <td>
                <div class="radio-group" style="vertical-align: bottom;">
                    <input type="radio" id="option-one" name="selector" value="BYN"><label for="option-one" onclick="$('#chooseCurrency').val('BYN')">BYN</label><input type="radio" id="option-two" name="selector" value="USD"><label for="option-two" onclick="$('#chooseCurrency').val('USD')">USD</label><input type="radio" id="option-three" value="EUR" name="selector"><label onclick="$('#chooseCurrency').val('EUR')" for="option-three">EUR</label><input type="radio" value=RUB" id="option-fourth" name="selector"><label onclick="$('#chooseCurrency').val('RUB')" for="option-fourth">RUB</label>
                </div>
            </td>
        </tr>
        <tr>
            <td class="label">Сумма:</td>
            <td style="padding-left: 10px;">
                <input type="text" id="summa" class="form" style="text-align: right;">
                <input type="text" id="chooseCurrency" disabled value="" style=" margin-left:2px; border: none; background-color: white; font-size: 11px; font-family: 'Theano Didot'; color:black;">
            </td>
        </tr>
        <tr>
            <td class="label">Срок депозита:</td>
            <td style="padding-left: 10px;">
                <select id="selectDuring" class="form" style="width:100px;">
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="9">9</option>
                    <option value="12">12</option>
                    <option value="18">18</option>
                    <option value="24">24</option>
                    <option value="36">36</option>
                </select>
                <input type="text" disabled value="мес." style=" margin-left:2px; border: none; background-color: white; font-size: 18px; font-family: 'Theano Didot'; color:black;">
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="Подобрать" style="margin-bottom: 30px;"></td>
        </tr>
    </table>
</form>
<div class="result" style="width:64%; float: right;" >
    <img src="${pageContext.request.contextPath}/resources/images/result.jpg" style="vertical-align:middle; padding-left:200px;" width="452" height="233">
</div>
</div>
<%@ include file="userFooter.jsp" %>
</body>
</html>