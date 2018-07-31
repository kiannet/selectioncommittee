<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.07.2018
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>FACULTY OF COMPUTER-AIDED DESIGN</title>
    <link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body>

<jsp:include page="${pageContext.request.contextPath}/jsp/newheader.jsp"></jsp:include>


<div class="container w">
    <div class="row centered">
        <br><br>
        <div class="col-lg-12">
            <h1>FACULTY OF ENGINEERING AND ECONOMICS</h1><br/>
            <h2>Academic departments:</h2>
            <h3>
                - Economics
                <br/>
                - Management
                <br/>
                - Economic Informatics
                <br/>
                - Foreign Languages No. 2
                <br/>
            </h3>
            <br/>
            <p>The Faculty of Engineering and Economics is a unique faculty in Belarus: it provides its students with integrated knowledge in the fields of economics and modern information technologies, and this creates a distinguished feature of the Faculty graduates among graduates of economic faculties of other Higher Educational Institutions. The Faculty is proud of one of its graduates,  Dmitry Shedko, Deputy Minister of Information of the Republic of Belarus.
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
