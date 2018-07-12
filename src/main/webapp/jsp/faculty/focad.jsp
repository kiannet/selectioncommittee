<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 03.07.2018
  Time: 17:00
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
            <h1>FACULTY OF COMPUTER-AIDED DESIGN</h1><br/>
            <h2>Academic departments:</h2>
                <h3>
                - Engineering Graphics
                <br/>
                - Foreign Languages No. 1
                <br/>
                - Human Engineering and Ergonomics
                <br/>
                - Electronic Technology and Engineering
                <br/>
                - Information and Computer-Aided Systems Design
                </h3>
            <br/>
            <p>The Faculty of Computer-Aided Design was opened in 1973. It is one of the most innovative and dynamically developing faculties in BSUIR. Faculty training facilities are based on international educational, scientific and production centres and laboratories, equipped with high-end hardware and software, as follows: Android Software Centre  – an international educational and scientific centre created in association with FORTE Knowledge company, Illinois Technology Association (ITA) and leading IT experts from the USA; an educational and research centre INTES established by an innovative company INTES with the support of foreign companies Schneider Electric (France) and CISCO (USA); a joint educational and scientific laboratory Integrated Mobile Systems established by an innovative company AXONIM Devices (a partner of Analog Devices, Texas Instruments and ST Microelectronics).
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
