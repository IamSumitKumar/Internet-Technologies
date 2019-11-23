/*6.1: Create your custom library which contains two tags: <hello>, <choco>.
Usage of the tags:
<hello name=”Ajay”>: Output should be Hello Ajay. It contains a mandatory attribute ‘name’ which can accept Dynamic value.
<choco texture=”Chewy”>: Output should be FiveStar, BarOne.
<choco texture=”Crunchy”>: Output should be Munch. KitKat.
That means the mandatory attribute must accept a value, and based on the attributes value, it should give output. You must use a bean ChocoBean for this purpose.*/
//!!! Resource @tutorials duniya

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="all" uri="/WEB-INF/tlds/custom" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP program6 tutorialsduniya.com</title>
	</head>
	<body>
		<all:hello name="${param.name}"/><br><br>
		<all:choco texture="${param.choc}"/>
	</body>
</html>