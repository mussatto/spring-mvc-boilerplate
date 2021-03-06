<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="menu.jsp"/>

<div class="container theme-showcase" role="main">

    <div class="jumbotron">
        <h1>Login</h1>
        <c:if test="${param.error}">
            <p>Username not exists or password incorrect</p>
        </c:if>
        <form:form id="loginForm" method="post" action="/spring-mvc-boilerplate/login" modelAttribute="user">
            <div>
                <label for="username" >UserName</label>
                <input type="text" id="username" name="username" placeholder="UserName" />

                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Password" />

                <input type="submit" value="Do Login"/>
            </div>

        </form:form>

    </div>
</div>
</body>

</html>