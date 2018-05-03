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
    <h1>Открытие депозита физ. лицу</h1>
    <form>
        <table style="width:37%; margin-left:30px;">
            <tr>
                <td class="label">Номер паспорта:</td>
                <td><input type="text" id="passportNumber" class="form"></td>
            </tr>
            <tr>
                <td class="label">Депозит:</td>
                <td>
                    <select id="selectDeposit" class="form" style="width:250px;">
                        <option value="BYN">65165165165316</option>
                        <option value="klk">dvsd5316</option>
                    </select>
                </td>
            </tr>
            <tr >
                <td class="label">Валюта:</td>
                <td><input type="text" id="currency" class="form" disabled><br></td>
            </tr>

            <tr>
                <td class="label">Номер счета:</td>
                <td><input type="text" id="accountNumber" class="form"><br></td>
            </tr>
            <tr>
                <td class="label">Начальная сумма:</td>
                <td>
                    <input type="text" id="summa" class="form" style="text-align: right;" value="0">
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Открыть"></td>
            </tr>
        </table>
    </form>

</div>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>