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
<div class="container">
    <div class="row centered">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-body">
                    <div class="col-lg-12">
        <c:forEach items="${faculties}" var="faculty">
            <form>
                <h2>
                    • ${faculty}
            <input type="hidden" name="faculty" value='${faculty}'/>
            <input type="hidden" name="command" value="more_about_faculty"/>
                <br/>
            <input type="submit" class="btn btn-default" value="MORE"/>
                </h2>
            </form>
            <br/>
        </c:forEach>
        </div>
    </div>
</div>
        </div>
    </div>
</div>
</body>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</html>
