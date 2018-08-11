<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 31.07.2018
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Admin profile</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>

<br/>
<br/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-info">
                <div class="panel-heading" style="background-color: #5a6268; color: whitesmoke">
                    <h3 class="panel-title">Your profile</h3>
                </div>
                <div class="panel-body">
                    <div class="row">

                        <div class=" col-md-9 col-lg-12 ">
                            <table class="table table-user-information">
                                <tbody>

                                <tr>
                                    <td>Username:</td>
                                    <td>${username}</td>
                                </tr>

                                <tr>
                                    <td>E-mail:</td>
                                    <td><a href="mailto:${email}">${email}</a></td>
                                </tr>

                                </tbody>
                            </table>
                            <div  class=" col-md-9 col-lg-12 " >
                                <a href="${pageContext.request.contextPath}/controller?command=to_change_admin_profile" class="btn btn-dark" style="background-color: grey; color: whitesmoke">Change profile</a>
                                <a href="${pageContext.request.contextPath}/controller?command=to_change_password" class="btn btn-dark" style="background-color: grey; color: whitesmoke">Change password</a>
                                <a href="${pageContext.request.contextPath}/controller?command=delete" class="btn btn-dark" style="background-color: grey; color: whitesmoke">Delete profile</a>
                                <a href="${pageContext.request.contextPath}/controller?command=logout" class="btn btn-dark" style="background-color: grey; color: whitesmoke">Log out</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
