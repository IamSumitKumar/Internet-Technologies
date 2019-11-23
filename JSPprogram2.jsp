/*2.1: Make two files as follows:
a. main.html: shows 2 text boxes and 3 radio buttons with values "addition",
"subtraction" and "multiplication"
b. operate.jsp: depending on what the user selects perform the corresponding
function (Give two implementations: using request.getParameter() and using
expression language)*/
//!!! Resource @tutorials duniya

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP program 2 tutorialsduniya.com</title>
</head>
<body>
    <c:set value="${param.n1}" var="num1"/>
    <c:set value="${param.n2}" var="num2"/>
    <c:set value="${param.op}" var="x"/>
    <c:choose>
        <c:when test="${x==1}">
            <c:out value="${num1+num2}"/>
        </c:when>
        <c:when test="${x==2}">
            <c:out value="${num1-num2}"/>
        </c:when>
        <c:when test="${x==3}">
            <c:out value="${num1*num2}"/>
        </c:when>
        <c:when test="${x==4}">
            <c:out value="${num1/num2}"/>
        </c:when>
        <c:otherwise>
            <c:out value="Wrong choice"/>
        </c:otherwise>
    </c:choose>
</body>
</html>