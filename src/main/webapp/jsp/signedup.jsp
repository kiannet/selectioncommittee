<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 05.05.2018
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h1>You've been successfully signed up!</h1>
                <form name="signedupForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="to_login">
                    <br/>
                    <br/>
                    <input type="submit" value="Log in">
                    <h4>or</h4>
                    <a href="${pageContext.request.contextPath}/controller?command=results">See results</a>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
