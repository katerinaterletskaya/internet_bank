<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Интернет-банк "BSB"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
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

<%@ include file="userHeader.jsp" %>
    <div class="content">

    <div class="main">
        <div class="account">
            <table class="accountTable">
                <thead>
                <tr>
                    <td class="pAccount">Счет</td>
                    <td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a
                            href="#">Открыть</a></td>
                </tr>
                </thead>
            </table>
        </div>
        <div class="change">
            <table class="changeTable">
                <thead>
                <tr><td class="pAccount">Обмен валют</td><td class="pResidue"><a href="#" id="achat">Покупка</a>/<a href="#" id="vente">Продажа</a></td></tr>
                </thead>

                <tbody>
                <%--<c:forEach items="currencyList" var="currency">--%>
                <%--<tr>--%>
                    <%--<td><input type="number" min="0" value="currency."></td>--%>
                    <%--<td><img src="${pageContext.request.contextPath}/resources/images/${currency.currency}.png"><label>${currency.currency}</label>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                    <tr>
                    <td><input type="number" min="0" value="0"></td>
                    <td><img src="${pageContext.request.contextPath}/resources/images/BYN.png"><label>BYN</label>
                    </td>
                    </tr>
                    <tr>
                    <td><input type="number" min="0" value="0"></td>
                    <td><img
                    src="${pageContext.request.contextPath}/resources/images/USD.png"><label>USD</label>
                    </td>
                    </tr>
                    <tr>
                    <td><input type="number" min="0" value="0"></td>
                    <td><img
                    src="${pageContext.request.contextPath}/resources/images/RUB.png"><label>RUB</label>
                    </td>
                    </tr>
                    <tr>
                    <td><input type="number" min="0" value="0"></td>
                    <td><img
                    src="${pageContext.request.contextPath}/resources/images/EUR.png"><label>EUR</label>
                    </td>
                    </tr>
                <%--</c:forEach>--%>
                </tbody>
            </table>
        </div>
    </div>

    <div class="info">
        <div class="loans">
            <table class="loansTable">
                <thead>
                <tr>
                    <td class="pAccount">Кредит</td>
                    <td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a
                            href="#">Оформить</a></td>
                </tr>
                </thead>
            </table>
        </div>
        <div class="deposit">
            <table class="depositTable">
                <thead>
                <tr>
                    <td class="pAccount">Депозит</td>
                    <td class="pResidue"><img src="${pageContext.request.contextPath}/resources/images/plus.png">&nbsp;<a
                            href="#">Открыть</a></td>
                </tr>
                </thead>
            </table>
        </div>
    </div>
    </div>

<%@ include file="userFooter.jsp" %>

</body>
</html>
