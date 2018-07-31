<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.07.2018
  Time: 14:00
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
            <h1>FACULTY OF INFOCOMMUNICATIONS</h1><br/>
            <h2>Academic departments:</h2>
            <h3>
                - Information Security
                <br/>
                - Infocommunication Technologies
                <br/>
                - Physical Training
                <br/>
            </h3>
            <br/>
            <p>The Faculty of Infocommunications is a wonderful opportunity for those who are eager to get experience in modern electronics and computer science, to master modern information technologies in telecommunications and become a highly sought-after professional. This Faculty was the 1st in Belarus to introduce English-medium degree programmes in the telecommunications sphere in 2009 and is still keeping the leading position today.  Faculty students take a deep insight into mathematical and physical bases of telecommunication technologies, and develop their skills of designing, programming and implementing innovative technologies. The expertise gained during studies helps graduates to quickly adapt to the requirements of the up-to-date telecommunication field.
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
