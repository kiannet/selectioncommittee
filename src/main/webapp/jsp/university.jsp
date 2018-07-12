<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 17.04.2018
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width", initial-scale=1.0>
    <title>About university</title>
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
            <h2>${university}</h2>
            <p>The Belarusian State University of Informatics and Radioelectronics is a big and friendly family of over 16 000 talented students, ca. 900 experienced faculty and thousands of successful alumni who are holding high responsible positions all over the world. Today the University is a large national research and educational centre possessing great workforce, scientific and training capacities, up-to-date laboratory equipment and extensive infrastructure. The University offers all necessary facilities for education, research, work, life and rest.</p>
            <p>The University strives to train engineers and scientists capable of generating and implementing innovative ideas, creating competitive high technology products in the spheres of computer science and electronics. This mission is fulfilled by means of sequential integration of education, research and innovation activities. This shall lead to the formation of balanced individuals who are capable to actively participate in the economic and social development of the society and who are committed to being responsible citizens full of patriotism and national pride.</p>
            <p>
                There six super faculties in the university:
                <br/>
                <c:forEach items="${faculties}" var="faculty">
                    - ${faculty}<br/>
                </c:forEach>
            </p>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/footer.jsp"></jsp:include>
</body>
</html>
