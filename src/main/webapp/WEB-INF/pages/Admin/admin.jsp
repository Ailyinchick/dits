<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-11-26
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<body>--%>
<%--&lt;%&ndash;<a href="<c:url value="/logout" />">Выйти</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h1> Hello ${user}</h1>&ndash;%&gt;--%>

<%--<a href="<c:url value="/createTest" />">Создать тест</a> <br>--%>
<%--<a href="<c:url value="/createUser" />">Создать пользователя</a> <br>--%>
<%--<a href="<c:url value="/adminStatistic" />">Статистика</a> <br>--%>
<%--<p>--%>
<%--<a href="<c:url value="/logout" />">Выйти</a>--%>

<%--</body>--%>
<%--</html>--%>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/res/user/mycont.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/link.css" rel="stylesheet" type="text/css">
    <title>
        Home
    </title>
</head>
<body>
<div class="mycont">
    <div class="margin-top8">


        <div class="row">
            <div class="col">
                <div class="mycont somefont">
<%--                    <h1> Hello ${user}</h1>--%>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">

                <div class="mycont">
                    <img src="${pageContext.request.contextPath}/resources/images/human.png">
                </div>

            </div>

            <div class="col">

                <div class="margin-top20">
                    <div class="mycont somefont">
                        <a href="<c:url value="/createTest" />">Создать тест</a> <br>
                        <a href="<c:url value="/createUser" />">Создать пользователя</a> <br>
                        <a href="<c:url value="/adminStatistic" />">Статистика</a> <br>
                    </div>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="mycont somefont">
                    <a href="<c:url value="/logout" />">Выйти</a>
                </div>
            </div>
        </div>

    </div>

</div>
</body>
</html>