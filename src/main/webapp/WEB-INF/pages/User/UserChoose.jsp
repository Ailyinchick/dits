<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<h1> Hello ${user}</h1>

<select>
    <option disabled> Название темы </option>
    <option> Тема 1 </option>
    <option> Тема 2 </option>
</select>
<br>
<select>
    <option disabled> Название теста </option>
    <option> Тест 1 </option>
    <option> Тест 2 </option>
</select>
<br>
<form action="/goTest" >
    <input type="submit" value="Пройти тестирование">
</form>

</body>
</html>