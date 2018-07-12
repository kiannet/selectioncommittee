<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 28.04.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>Selection committee</title>
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
                <h1>BELARUSIAN STATE UNIVERSITY OF INFORMATICS AND RADIOELECTRONICS</h1>
                <h2>On the way to success!</h2>
            </div>
        </div>
    </div>

    <div class="container w">
        <div class="row centered">
            <br><br>
            <div class="col-lg-4">
                <h4>Knowledge</h4>
                <p>Best teachers and modern training program</p>
            </div>
            <div class="col-lg-4">
                <h4>Comfort</h4>
                <p>New teaching rooms and equipment</p>
            </div>
            <div class="col-lg-4">
                <h4>Future</h4>
                <p>Studying of advanced technologies and cooperation with leading companies</p>
            </div>
        </div>
    </div>

    <div id="dg">
        <div class="container">
            <div class="row centered">
                <h4>Faculties</h4>
                <br>
                <div class ="col-lg-4">
                    <div class="tilt">
                        <a href="${pageContext.request.contextPath}/jsp/faculty/focad.jsp">FACULTY OF COMPUTER-AIDED DESIGN</a>
                    </div>
                </div>
                <div class ="col-lg-4">
                    <div class="tilt">
                        <a href="#">FACULTY OF INFORMATION TECHNOLOGIES AND CONTROL</a>
                    </div>
                </div>
                <div class ="col-lg-4">
                    <div class="tilt">
                        <a href="#">FACULTY OF RADIOENGINEERING AND ELECTRONICS</a>
                    </div>
                </div>
                <div class ="col-lg-4">
                    <div class="tilt">
                        <a href="#">FACULTY OF COMPUTER SYSTEMS AND NETWORKS</a>
                    </div>
                </div>
                <div class ="col-lg-4">
                    <div class="tilt">
                        <a href="#">FACULTY OF INFOCOMMUNICATIONS</a>
                    </div>
                </div>
                <div class ="col-lg-4">
                    <div class="tilt">
                        <a href="#">FACULTY OF ENGINEERING AND ECONOMICS</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container wb">
        <div class="row centered">
            <br><br>
            <div class="col-lg-8 col-lg-offset-2">
                <h4>MINSK</h4>
                <p>Belarus</p>
            </div>
            <div class="col-lg-2"></div>
            <div class="col-lg-10 col-lg-offset-1">
                <img scr="../img/bsuir.jpg" alt="" class="img-responsive">
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleaplis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
