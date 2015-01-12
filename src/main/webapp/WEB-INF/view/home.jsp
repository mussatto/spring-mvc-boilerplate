<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
    <jsp:include page="menu.jsp"/>

    <div class="container theme-showcase" role="main">
        <div class="jumbotron">
            <c:if test="${param.login}">
                <p>Welcome!</p>
            </c:if>

            <h1>Home</h1>
            <p>This is the home page</p>

            <h1>Hello, ${name}!!</h1>
            <form method="post" action="user/create">
                <input value="test user"/>
                <input type="button" class="btn btn-primary btn-lg" value="do action"/>
            </form>
        </div>
    </div>
</body>

</html>