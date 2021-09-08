<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/9/2021
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> day la trang list</h3>

<c:forEach items="${list}" var="item">
    ${item.name}<br>
</c:forEach>
</body>
</html>
