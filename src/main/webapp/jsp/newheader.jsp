<%--
  Created by IntelliJ IDEA.
  User: kiannet
  Date: 02.05.2018
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/carousel.jsp">BSUIR</a>
        </div>
        <div class="navbar-collapse collapse">
            <c:if test="${sessionScope.role == 'guest'}">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${pageContext.request.contextPath}/jsp/carousel.jsp">Main page</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=touniversity">About University</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=tofaculties">Faculties</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=results">Results</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=findlist">Sign up</a></li>
                <li><form name=" changeLocalForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="changelanguage">
                <ul class="list-inline">
                    <li><button class="list-inline-item" class="localbutton" type="submit" name="locale" value="en_US">EN</button></li>
                    <li><button class="list-inline-item" class="localbutton" type="submit" name="locale" value="ru_RU">RU</button></li>
                </ul>
                </form>
                </li>
            </ul>
            </c:if>
            <c:if test="${sessionScope.role == 'user'}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="${pageContext.request.contextPath}/jsp/carousel.jsp">Main page</a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=touniversity">About University</a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=tofaculties">Faculties</a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=results">Results</a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=profile">Profile</a></li>
                    <li><form name=" changeLocalForm" method="POST" action="controller">
                        <input type="hidden" name="command" value="changelanguage">
                        <li><button class="localbutton" type="submit" name="locale" value="en_US">EN</button></li>
                        <li><button class="localbutton" type="submit" name="locale" value="ru_RU">RU</button></li>
                    </form>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
</div>
