<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Диаграмма расходов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user.css" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/Chart.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../user/userHeader.jsp" %>
<div class="content" style="width:90%;">
    <form action="${pageContext.request.contextPath}/user/diagram/chart" method="post">
        <table style="width:37%; margin-left:30px;">
            <tr>
                <td class="label">Со счета:</td>
                <td>
                    <select id="selectFromAccount" name="number" class="form" style="width:250px;">
                        <c:forEach items="${numbers}" var="number">
                            <option>${number.number}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Вывести"></td>
            </tr>
        </table>
    </form>
    <input type="hidden" id="sums" value="${sums}">
    <input type="hidden" id="categories" value="${categories}">
    <canvas id="myChart" width="800" height="400"></canvas>
</div>
<script>
    var massiv;
    var floatMassiv = new Array(8);
    massiv =$("#sums").val();
    var spMassiv=massiv.split(',');
    spMassiv[0]=spMassiv[0].split('[')[1];
    spMassiv[spMassiv.length-1]=spMassiv[spMassiv.length-1].split(']')[0];
    floatMassiv[0]=parseFloat(spMassiv[0]);
    floatMassiv[1]=parseFloat(spMassiv[1]);
    floatMassiv[2]=parseFloat(spMassiv[2]);
    floatMassiv[3]=parseFloat(spMassiv[3]);
    floatMassiv[4]=parseFloat(spMassiv[4]);
    floatMassiv[5]=parseFloat(spMassiv[5]);
    floatMassiv[6]=parseFloat(spMassiv[6]);
    floatMassiv[7]=parseFloat(spMassiv[7]);

    var ctx = document.getElementById("myChart").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Билеты", "Интернет", "Интернет-магазины", "МВД", " Мобильная связь", "СМИ", "Таможенные платежи", "Суды"],            datasets: [{
                label: '',
                data: floatMassiv,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)',
                    'rgba(0,0,0,0.3)',
                    'rgba(139, 69, 19,0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                    'rgba(0,0,0,1)',
                    'rgba(139, 69, 19, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                    }
                }]
            },
            responsive: true,
            maintainAspectRatio: false
        }
    });
</script>
<%@ include file="../user/userFooter.jsp" %>
</body>
</html>