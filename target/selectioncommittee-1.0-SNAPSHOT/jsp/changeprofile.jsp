<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 01.05.2018
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change your profile</title>
</head>
<body>
<form name="changeProfileForm" method="POST" action="controller">
    <input type="hidden" name="command" value="changeprofile">
    <br/>
    <input type="submit" value="Change my profile">
</form>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
