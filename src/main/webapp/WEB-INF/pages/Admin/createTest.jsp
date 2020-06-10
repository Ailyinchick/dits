<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 07.12.2019
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CreateTest</title>
    <link href="${pageContext.request.contextPath}/res/user/input.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/mycont.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/button.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/link.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

                <div class="margin-top20">
                    <div class="mycont somefont">


                        <form action="saveNewQuestion">
                            <p>
                                <input type="text" class="css-input" required list="topics" placeholder="Выберите тему"
                                       id="topic" name="topic">

                                <datalist id="topics" name="nameTopic">
                                    <c:forEach items="${topics}" var="topic">

                                    <option value="${topic}">

                                        </c:forEach>
                                </datalist>
                            </p>

                            <p>
                                <input type="text" class="css-input" required list="tests" placeholder="Выберите тест"
                                       id="test" name="test">

                                <datalist id="tests">
                                    <c:forEach items="${tests}" var="test">

                                    <option value="${test}">

                                        </c:forEach>
                                </datalist>
                            </p>

                            <p>
                                <input type="text" class="css-input" required list="questions"
                                       placeholder="Выберите вопрос" id="question" name="question">

                                <%--        <input list="questions" required name="nameQuestion">--%>
                                <datalist id="questions">
                                    <c:forEach items="${questions}" var="question">

                                    <option value="${question}">

                                        </c:forEach>
                                </datalist>
                            </p>

                            <input type="submit" class="myButton" value="Отправить"></p>

                        </form>
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

<p id="success"><a style="color: green; font-size: 120%;">${success}</a></p>

<script>
    setTimeout(function () {
        document.getElementById("success").style.display = 'none';
    }, 4000)
</script>

</body>
</html>
