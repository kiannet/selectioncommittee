<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 31.07.2018
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Users</title>
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
                        <c:forEach items="${users}" var="user">
                            <form name="deleteUser" method="POST" action="controller">
                                <input type="hidden" name="command" value="delete_user"/>
                                <h3>
                                    <input type="hidden" name="id" value="${user.userId}" />
                                    ${user.userId} ${user.username} ${user.email} ${user.ban}
                                    <br/>
                                    <input type="submit" class="btn btn-default" value="Delete"/>
                                </h3>
                            </form>

                            <c:if test="${user.ban == 'true'}">
                                <form name="unbanUser" method="POST" action="controller">
                                    <input type="hidden" name="command" value="unban_user"/>
                                    <h3>
                                        <input type="hidden" name="id" value="${user.userId}" />
                                        <input type="submit" class="btn btn-default" value="Unban"/>
                                    </h3>
                                </form>
                            </c:if>

                            <form name="banUser" method="POST" action="controller">
                                <input type="hidden" name="command" value="ban_user"/>
                                <h3>
                                <input type="hidden" name="id" value="${user.userId}" />
                                <input type="submit" class="btn btn-default" value="Ban"/>
                                </h3>
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
