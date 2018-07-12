<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 28.04.2018
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Enrollees</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>
<div class="container w">
    <div class="row centered">
        <br><br>
        <div class="col-lg-12">
            <h4>Enrollees from ${specialty}:</h4>
            <c:forEach items="${enrollees}" var="enrollee">
                <h5>
                        ${enrollee.getSurname()} ${enrollee.getName()} ${enrollee.getSecondName()} (${enrollee.getSum()} points)
                </h5>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
