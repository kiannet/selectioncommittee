<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.07.2018
  Time: 13:43
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
            <h1>FACULTY OF RADIOENGINEERING AND ELECTRONICS</h1><br/>
            <h2>Academic departments:</h2>
            <h3>
                - Electronics
                <br/>
                - Micro- and Nanoelectronics
                <br/>
                - Information Radiotechnologies
                <br/>

            </h3>
            <br/>
            <p>The Faculty of Radioengineering and Electronics has a rich history. It was founded in 1964 as a part of Minsk Radio Engineering Institute. The achievements of the Faculty’s scientists are recognised all over the world. Their research outcomes are used in spacecraft and missiles, radiolocation systems, advanced micro- and nanoelectronics. Faculty`s textbooks, tutorials and monographs are published both in Belarus and abroad. At this Faculty you will get an education that will make you a unique expert  in the field of radio information systems, micro- and nanoelectronic technologies and systems, and that will give you an opportunity to realise yourself in full in the society of the XXI century.
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
