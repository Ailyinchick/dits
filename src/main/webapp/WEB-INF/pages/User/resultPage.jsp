<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/res/user/mycont.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/link.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/table.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/res/user/button.css" rel="stylesheet" type="text/css">
    <title>
        Result
    </title>
</head>
<body>

<div class="mycont">
    <div class="margin-top8">

        <div class="row">
            <div class="col">
                <div class="mycont">

                    <table class="blueTable">
                        <thead>
                        <tr>
                            <th>Название вопроса</th>
                            <th>Правильно</th>
                            <th>Рекомендуемая литература</th>
                            <th>Рекомендуемые ссылки на литературу</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${statistic}" var="item">
                            <tr>
                                <td> ${item.question.description} </td>
                                <td> ${item.correct} </td>
                                <td> ${item.question.literatures} </td>
                                <td>
                                    <c:forEach items="${item.question.literatureList}" var="lit">
                                        <a href="<c:url value="${lit.casualLinks}" />">${lit.casualLinks}</a> <br>

                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="mycont somefont">
                    <form action="${pageContext.request.contextPath}/goUserHome">
                        <input class="myButton" type="submit" value="Home page">
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>


</body>
</html>