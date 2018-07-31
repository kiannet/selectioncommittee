<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.07.2018
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            <h1>FACULTY OF COMPUTER SYSTEMS AND NETWORKS</h1><br/>
            <h2>Academic departments:</h2>
            <h3>
                - Physics
                <br/>
                - Philosophy
                <br/>
                - Computer Science
                <br/>
                - Higher Mathematics
                <br/>
                - Electronic Computing Facilities
                <br/>
                - Electronic Computing Machines
                <br/>
                - Software for Information Technologies
                <br/>
            </h3>
            <br/>
            <p>The Faculty of Computer Systems and Networks originates from one of the first faculties of Minsk Radio Engineering Institute – the Faculty of Automatics and Calculating Machines. Today it’s one of the leading Belarusian faculties, which trains IT professionals.  Thirteen joint laboratories and certified education centres support teaching process and hold additional IT courses. In 2012, the IBM Academic Centre of Competence based on the joint BSUIR-IBA laboratory was awarded a prestigious prize under the IBM Faculty Awards programme. Other certified centres include SAP Academic Competence Centre, National Instruments Training Centre, CUDA Training Centre and Cisco Network Academy. Faculty students take a deep insight into programming technologies and languages (Pascal, C/C++, Assembler, C#, Java, .NET etc.), database control systems (MySQL, MS SQL Server, Oracle etc.), web-technologies (HTML, CSS, XML, PHP etc.), technologies of software development and QA, software and hardware support of computer networks, etc.
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
