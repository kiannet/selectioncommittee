<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 12.04.2018
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Your profile</title>
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
                                    <td>Surname:</td>
                                    <td>${surname}</td>
                                </tr>
                                <tr>
                                    <td>Name:</td>
                                    <td>${name}</td>
                                </tr>
                                <tr>
                                    <td>Second name:</td>
                                    <td>${secondname}</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>E-mail:</td>
                                    <td><a href="mailto:${email}">${email}</a></td>
                                </tr>
                                <tr>
                                    <td>Username:</td>
                                    <td>${username}</td>
                                </tr>
                                <tr>
                                    <td>Phone:</td>
                                    <td>${phone}</td>
                                </tr>
                                <tr>
                                    <td>Passport ID:</td>
                                    <td>${passportid}</td>
                                </tr>
                                <tr>
                                    <td>Specialty:</td>
                                    <td>${specialty}</td>
                                </tr>
                                <tr>
                                    <td>${fsubjectname}:</td>
                                    <td>${fpoints}</td>
                                </tr>
                                <tr>
                                    <td>${ssubjectname}:</td>
                                    <td>${spoints}</td>
                                </tr>
                                <tr>
                                    <td>${tsubjectname}:</td>
                                    <td>${tpoints}</td>
                                </tr>
                                <tr>
                                    <td>Certificate:</td>
                                    <td>${certificate}</td>
                                </tr>


                                </tr>

                                </tbody>
                            </table>
                            <div  class=" col-md-9 col-lg-6 " >
                                <a href="${pageContext.request.contextPath}/controller?command=to_change_profile" class="btn btn-dark" style="background-color: grey; color: whitesmoke">Change profile</a>
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
