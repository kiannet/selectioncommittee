<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.07.2018
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Change password</title>
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
                        <h2>CHANGE PASSWORD</h2>
                        <form name="signupForm" method="POST" action="controller">
                            <input type="hidden" name="command" value="change_password"/>

                            <h4>PASS:${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="oldpassword" class="form-control" value=" "/>
                            </div>

                            <h4>PASS:${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="newpassword" class="form-control" value=" "/>
                            </div>

                            <h4>PASS:${enter}</h4>
                            <div class="form-group">
                                <input type="text" name="confirmnewpassword" class="form-control" value=" "/>
                            </div>

                            <br/>

                            ${incorrectpassmess}
                            <br/>
                            <input type="submit" class="btn btn-default" value="Save password"/>
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
