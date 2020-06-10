<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/res/user/input.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/mycont.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/button.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<div class="mycont">
    <div class="margin-top8">

        <c:url var="loginUrl" value="/login"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
            <p>
                <input type="text" class="login-field css-input" id="username" name="ssoId"
                       placeholder="Логин"
                       value=""
                       required>
            </p>
            <p>
                <input type="password" class="password-field css-input" id="password" name="password"
                       placeholder="Пароль"
                       value=""
                       required>
            </p>
            <p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </p>
            <p>
                <input type="submit" class="myButton" value="Войти">
            </p>

        </form>


    </div>

</div>

</body>
</html>