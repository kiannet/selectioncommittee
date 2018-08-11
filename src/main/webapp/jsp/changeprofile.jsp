<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 01.05.2018
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>CHANGE PROFILE</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
    <script src="${pageContext.request.contextPath}/js/specialty.js"></script>
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>

<br/>
<div class="container">
    <div class="row centered">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-body">
                    <div class="col-lg-12">
                        <h2>CHANGE INFORMATION, ${username}</h2>
                        <form name="signupForm" method="POST" action="controller">
                            <input type="hidden" name="command" value="change_profile"/>


                            <h4>Surname:${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="surname" class="form-control" value="${surname}"/>
                            </div>

                            <h4>Name:${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" value="${name}"/>
                            </div>

                            <h4>Second name:${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="secondname" class="form-control" value="${secondname}"/>
                            </div>

                            <h4>Passport ID: ${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="passportID" class="form-control" value="${passportid}"/>
                            </div>

                            <h4>Phone number: ${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="phone" class="form-control" value="${phone}"/>
                            </div>

                            <br/>
                            <br/>
                            ${specialtiesByFaculty}
                            <br/>
                            ${errorEmptyValuesMessage}
                            <br/>
                            <input type="submit" class="btn btn-default" value="Save changes"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
