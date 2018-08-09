<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 27.03.2018
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Welcome</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>
<div id="headerwrap">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <br/>
                <br/>
                <br/>
                <h1>Welcome, ${user}!</h1>
                <form name="logoutForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="logout">
                    <br/>
                    <br/>
                <c:if test="${sessionScope.role == 'user'}">
                    <a href="${pageContext.request.contextPath}/controller?command=profile">See your profile</a>
                </c:if>
                <c:if test="${sessionScope.role == 'admin'}">
                    <a href="${pageContext.request.contextPath}/controller?command=admin_profile">See your profile</a>
                </c:if>
    <h4>or</h4>
                    <a href="${pageContext.request.contextPath}/controller?command=results">See results</a>
                    <h4>or</h4>
                    <input type="submit" value="Log out">
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
