<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 28.03.2018
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>SIGN UP</title>
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
            <form name=" toLoginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="to_login"/>
                <h2>ALREADY HAS AN ACCOUNT?</h2>
                <input type="submit" class="btn btn-default" value="Loig in"/>
            </form>
            <h2>OR SIGN UP RIGHT NOW</h2>
            <form name="signupForm" method="POST" action="controller" onsubmit="return validationRegister();">
                <input type="hidden" name="command" value="signup"/>


                <h4>Surname:*</h4>
                <h5>(with a capital letter)</h5>
                <div class="form-group">
                <input type="text" name="surname" class="form-control" placeholder="enter surname"/>
                </div>

                <h4>Name:*</h4>
                <h5>(with a capital letter)</h5>
                <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="enter name"/>
                </div>

                <h4>Second name:*</h4>
                <h5>(with a capital letter)</h5>
                <div class="form-group">
                <input type="text" name="secondname" class="form-control" placeholder="enter second name"/>
                </div>

                <h4>Email:*</h4>
                <div class="form-group">
                <input type="text" name="email" class="form-control" placeholder="enter email"/>
                </div>

                <h4>Login:*</h4>
                <h5>(may contain numbers, at least 2 characters)</h5>
                <div class="form-group">
                <input type="text" name="login" class="form-control" placeholder="enter login"/>
                </div>

                <h4>Password:*</h4>
                <h5>(must contain a capital letter, a number and minimal length is 8)</h5>
                <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="enter password"/>
                </div>


                <h4>Confirm password:*</h4>
                <div class="form-group">
                <input type="password" name="passwordcheck" class="form-control" placeholder="confirm password"/>
                </div>

                <h4>Passport ID:*</h4>
                <h5>(in XX1234567 format)</h5>
                <div class="form-group">
                <input type="text" name="passportID" class="form-control" placeholder="enter passport ID"/>
                </div>

                <h4>Phone number:*</h4>
                <h5>(in (123)4567890 format)</h5>
                <div class="form-group">
                <input type="text" name="phone" class="form-control" placeholder="enter phone number"/>
                </div>

                <h4>First subject:*</h4>
                <div class="form-group">
                <select name="subject1" class="form-control">
                    <c:forEach items="${subjects}" var="subject">
                        <option>${subject}</option>
                    </c:forEach>
                </select>
                </div>

                <h4>Points:*</h4>
                <h5>(number from 1 to 100)</h5>
                <div class="form-group">
                <input type="text" name="points1" class="form-control" placeholder="enter points"/>
                </div>

                <h4>Second subject:*</h4>
                <div class="form-group">
                <select name="subject2" class="form-control">
                    <c:forEach items="${subjects}" var="subject">
                        <option>${subject}</option>
                    </c:forEach>
                </select>
                </div>

                <h4>Points:*</h4>
                <h5>(number from 1 to 100)</h5>
                <div class="form-group">
                <input type="text" name="points2" class="form-control" placeholder="enter points"/>
                </div>

                <h4>Third subject:*</h4>
                <div class="form-group">
                <select name="subject3" class="form-control">
                    <c:forEach items="${subjects}" var="subject">
                        <option>${subject}</option>
                    </c:forEach>
                </select>
                </div>

                <h4>Points:*</h4>
                <h5>(number from 1 to 100)</h5>
                <div class="form-group">
                <input type="text" name="points3" class="form-control" placeholder="enter points"/>
                </div>

                <h4>Certificate:*</h4>
                <h5>(number from 1 to 100)</h5>
                <div class="form-group">
                <input type="text" name="certificate" class="form-control" placeholder="enter certificate points"/>
                </div>

                <h4>Faculty:*</h4>
                <div class="form-group">
                <select onChange="getSpecialties(this)" name="faculty" class="form-control">
                    <c:forEach items="${faculties}" var="faculty">
                        <option>${faculty}</option>
                    </c:forEach>
                </select>
                </div>

                <h4>Specialty:*</h4>
                <div class="form-group">
                <select id="specialty" name = "specialty" class="form-control">
                </select>
                </div>

                <h5>*All fields are required.</h5>
                <br/>

                ${errorEmptyValuesMessage}
                <br/>
                <input type="submit" class="btn btn-default" value="Sign up"/>
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
