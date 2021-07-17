<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Message: ${msg}</h1>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2 style="color: blue">${pageContext.request.userPrincipal.name}</h2>

    <a href="*/logout"> LOGOUT </a>
</c:if>

</body>
</html>
