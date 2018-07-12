<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 24.04.2018
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Results</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
    <script src="${pageContext.request.contextPath}/js/specialty.js"></script>
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>

<div class="container">
    <div class="row centered">
        <div class="col-lg-8 col-lg-offset-2">
            <form name=" resultsForm" method="POST" action="controller">
                <input type="hidden" name="command" value="updateresults"/>
                <br/>
                <h2>WANT TO KNOW YOUR COMPETITORS?</h2>
                <h4>check right now</h4>
                <h1>Choose the faculty:</h1>
                <div class="form-group">
                <select onchange="getSpecialties(this)" class="form-control">
                    <c:forEach items="${faculties}" var="faculty">
                        <option>${faculty}</option>
                    </c:forEach>
                </select>
                </div>
                <h1>Choose the specialty:</h1>
                <div class="form-group">
                <select id="specialty" name = "specialty" class="form-control">
                    <c:forEach items="${specialties}" var="specialty">
                        <option>${specialty}</option>
                    </c:forEach>
                </select>
                </div>
                <br/>
            <br/>
                <input type="submit" class="btn btn-default" value="Show results"/>
            </form>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
