<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 26.03.2018
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title><fmt:message key="label.singIn" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
    </head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>
<div class="container">
    <div class="row centered">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                <form name=" loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="login"/>
                <h2>LOGIN:</h2>
                    <div class="form-group">
                <input type="text" name="login" class="form-control" placeholder="enter login"/>
                    </div>
                <h2>PASSWORD:</h2>
                    <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="enter password"/>
                    </div>
                    <a class="href" href="/jsp/forgotpassword.jsp">Forgot password?</a>
                    <br/>
                    <a href="${pageContext.request.contextPath}/controller?command=findlist">New user?</a>
                    <br/>
                    <br/>
                <input type="submit" class="btn btn-default" value="Log in"/>
                    ${emptyUsernameOrPassword}
                    ${errorLoginPassMessage}
                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${request.contextPath}/lib/js/jquery-3.3.1.min.js"></script>
<script src="${request.contextPath}/lib/js/bootstrap.min.js"></script>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
