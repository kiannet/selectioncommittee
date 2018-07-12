<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 16.04.2018
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Header</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${request.contextPath}/lib/css/bootstrap.min.css">
    <script src="${request.contextPath}/lib/js/jquery-3.3.1.min.js"></script>
    <script src="${request.contextPath}/lib/js/bootstrap.min.js"></script>
</head>
<body>
${sessionScope.role}
<div class="col-md-10 col-md-offset-5">
    <div class="small" id="header-scroll">
<c:if test="${sessionScope.role == 'guest'}">
        <h1><a href="#">TITLE</a></h1>
        <nav>
            <ul>
                <li><a href="/jsp/carousel.jsp">
                    Main
                </a></li>
                <li><form name=" changeLocalForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="changelanguage">
                    <button class="localbutton" type="submit" name="locale" value="en_US">EN</button>
                    <button class="localbutton" type="submit" name="locale" value="ru_RU">RU</button>
                </form></li>
                <li><form name=" universityForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="touniversity"/>
                    <input class="mybutton" type="submit" value="About university"/>
                </form></li>
                <li><form name=" facultiesForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="tofaculties"/>
                    <input class="mybutton" type="submit" value="Faculties"/>
                </form></li>
                <li><form name=" resultsForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="results"/>
                    <input class="mybutton" type="submit" value="Results"/>
                </form></li>
                <li><form name=" signupForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="findlist"/>
                    <input class="mybutton" type="submit" value="Sign up"/>
                </form></li>
            </ul>
        </nav>
    </div>
    </div>
</c:if>
<c:if test="${sessionScope.role == 'user'}">
        <div class="col-md-10 col-md-offset-5">
            <div class="small" id="header-scroll">
                <h1><a href="#">TITLE</a></h1>
                <nav>
                    <ul>
                        <li><form name=" universityForm" method="POST" action="controller">
            <input type="hidden" name="command" value="touniversity"/>
            <input class="mybutton" type="submit" value="About university"/>
                        </form></li>
                        <li><form name=" facultiesForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tofaculties"/>
            <input class="mybutton" type="submit" value="Faculties"/>
                        </form></li>
                        <li><form name=" resultsForm" method="POST" action="controller">
            <input type="hidden" name="command" value="results"/>
            <input class="mybutton" type="submit" value="Results"/>
                        </form></li>
                        <li><form name=" profileForm" method="POST" action="controller">
            <input type="hidden" name="command" value="profile"/>
            <input class="mybutton" type="submit" value="Profile"/>
                        </form></li>
                    </ul>
                </nav>
    </div>
        </div>

</c:if>
<c:if test="${sessionScope.role == 'admin'}">
    <div class="col-md-10 col-md-offset-5">
        <form name=" universityForm" method="POST" action="controller">
            <input type="hidden" name="command" value="touniversity"/>
            <input type="submit" value="About university"/>
        </form>
        <form name=" facultiesForm" method="POST" action="controller">
            <input type="hidden" name="command" value="tofaculties"/>
            <input type="submit" value="Faculties"/>
        </form>
        <form name=" resultsForm" method="POST" action="controller">
            <input type="hidden" name="command" value="results"/>
            <input type="submit" value="Results"/>
        </form>
        <form name=" profileForm" method="POST" action="controller">
            <input type="hidden" name="command" value="allusers"/>
            <input type="submit" value="Users"/>
        </form>
    </div>
</c:if>
</body>
</html>
