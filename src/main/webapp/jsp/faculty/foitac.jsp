<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.07.2018
  Time: 13:38
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
            <h1>FACULTY OF INFORMATION TECHNOLOGIES AND CONTROL</h1><br/>
            <h2>Academic departments:</h2>
            <h3>
                - Humanities
                <br/>
                - Control Systems
                <br/>
                - Fundamental Electrical Engineering
                <br/>
                - Intellectual Information Technologies
                <br/>
                - Computational Methods and Programming
                <br/>
                - Information Technologies in Automated Systems
                <br/>
            </h3>
            <br/>
            <p>The Faculty of Information Technologies and Control is the coeval of the University. Nowadays the Faculty is a large educational and scientific centre with more than 1,700 students. Our academic staff regularly keeps its experience up-to-date in the leading universities of the USA, Canada, Great Britain, Germany, France, Austria and Poland. Moreover, Faculty scientists have strong business relations with the universities of the USA, Germany, Poland, Finland, the Netherlands and France. The Faculty maintains close partnerships with world leading manufacturers of computers & control systems, such as IBM, Siemens, Philips, Intel, Motorola, Omron IBM, IBА, EPAM Systems, Itransition, TopSoft, Galaktika Corp., and etc.
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
