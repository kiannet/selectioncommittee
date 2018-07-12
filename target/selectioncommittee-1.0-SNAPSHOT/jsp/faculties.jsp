<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 17.04.2018
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Faculties</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>
<br/>
<br/>
<br/>
<br/>
<br/>
<c:forEach items="${faculties}" var="faculty">
    <form>
    ${faculty}
        <input type="hidden" name="faculty" value=${faculty}>
        <input type="hidden" name="command" value="moreaboutfaculty"/>
        <br/>
        <input type="submit" value="More..."/>
    </form>
<br/>
</c:forEach>

</body>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</html>
