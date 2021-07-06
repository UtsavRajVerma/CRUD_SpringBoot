<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Success Page</title>

    <br>
    <h5>Form generated!</h5><br>
    <br>
    <h6>Name:&nbsp; <span th:text=${name}></span></h6><br>
    <h6>Email:&nbsp; <span th:text=${email}></span></h6><br>
    <h6>Mobile:&nbsp; <span th:text=${phone}></span></h6><br>
    <h6>State: &nbsp;<span th:text=${state}></span></h6><br>
    <h6>Gender:&nbsp; <span th:text=${gender}></span></h6><br>
    <h6>Skills:&nbsp; <span th:text=${skills}></span></h6><br>

    <!--  <a th:href="@{/update/{id}(id=${form.id})}" class="btn btn-primary">-->
    <a href="http://localhost:63342/SpringBoot_v2/templates/index.html" class="btn btn-primary">
        <label class="btn btn-primary" for="btn-check-2">Edit form</label>
    </a>

</head>
<body>

</body>
</html>