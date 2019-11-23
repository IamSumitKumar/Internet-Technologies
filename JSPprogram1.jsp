/*1.1: Display the pattern:
1
1 2
1 2 3
Take ‘n’ in a textbox from user. Display this pattern using
(a) Scriptlets
(b) <c:forEach> loop*/
//!!! Resource @tutorials duniya

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Pattern Tutorialsduniya.com</title>
	</head>
	<body>
		<% int n=Integer.parseInt((request.getParameter("name")));
			int i,j;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=i;j++)
					out.print(j);
				out.println("<br>");
			}
		%>
	</body>
</html>
