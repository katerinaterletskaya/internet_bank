<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/register" method="post">
        <p> Укажите ваши личные данные, номер паспорта, указанный в
            паспорте гражданина Республики Беларусь или в виде на жительство в Республике Беларусь, а также ваш логин-email и пароль.</p>
        <div class="clearfix">
            <input type="text" autocomplete="off" name="surname" id="surname" class="form" placeholder="Фамилия">
        </div>
        <div class="clearfix">
            <input type="text" autocomplete="off" name="name" id="name" class="form" placeholder="Имя">
        </div>
        <div class="clearfix">
            <input type="text" autocomplete="off" name="patronymic" id="patronymic" class="form" placeholder="Отчество">
        </div>
        <div class="clearfix">
            <input type="text" autocomplete="off" name="passport" id="passport" class="form" placeholder="№ паспорта">
        </div>
        <div class="clearfix">
            <input type="email" autocomplete="off" name="login" id="login" class="form" placeholder="Логин">
        </div>
        <div class="clearfix">
            <input type="password" autocomplete="off" name="password" id="password" class="form" placeholder="Пароль">
        </div>
        <div class="clearfix">
            <input type="submit" value="Регистрация">
        </div>
    </form>
</body>
</html>
