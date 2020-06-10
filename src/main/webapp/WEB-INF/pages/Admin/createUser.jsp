<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 07.12.2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>CreateUser</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/res/user/mycont.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/link.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/input.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/button.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="mycont">
    <div class="margin-top8">


        <div class="row">
            <div class="col">

                <div class="mycont">
                    <img src="${pageContext.request.contextPath}/resources/images/human.png">
                </div>

            </div>

            <div class="col">
<%--class="margin-top20"--%>
                <div >
                    <div class="mycont somefont">


    <form:form method="post" action="/createUser" modelAttribute="user">

        <table>

            <tr>
                <td><form:select  cssClass="css-input" path="nameRole"> <form:options items="${allRoles}"/> </form:select></td>
            </tr>

            <tr>
                <td><form:input autocomplete="false" cssClass="css-input" path="lastName" placeholder="Фамилия" required="true"/></td>
            </tr>
            <tr>
                <td><form:input cssClass="css-input" path="firstName" placeholder="Имя" required="true"/></td>
            </tr>
            <tr>
                <td><input class="css-input" placeholder="Отчество"/></td>
            </tr>
            <tr>
                <td><form:password cssClass="css-input" path="password" placeholder="Пароль" required="true"/></td>
            </tr>
            <tr>
                <td><form:input cssClass="css-input" path="login" placeholder="Логин" required="true"/></td>
            </tr>
            <tr>
                <td><input class="css-input" placeholder="Почта"/></td>
            </tr>

            <tr>
                <td><input class="myButton" type="submit" value="Сохранить пользователя"/></td>
            </tr>

        </table>
    </form:form>
                    </div>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="mycont somefont">
                    <a href="<c:url value="/goHomeAdmin" />">Назад</a>
                </div>
            </div>
        </div>

    </div>

</div>

<script>
    setTimeout(function () {
        document.getElementById("success").style.display = 'none';
    }, 4000)
</script>

<%--<div class="CreateUser">--%>
<%--    --%>
<%--    <p id="success"><a style="color: green; font-size: 120%;">${success}</a></p>--%>
<%--</div>--%>



</body>
</html>
