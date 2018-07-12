<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 01.05.2018
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile changed</title>
</head>
<body>
Your profile has been successfully changed.
<form name=" profileForm" method="POST" action="controller">
    <input type="hidden" name="command" value="profile"/>
    <input type="submit" value="Profile"/>
</form><hr/>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
