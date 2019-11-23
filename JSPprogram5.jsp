/*5.1: Let the user enter a word a in a textbox and let her/him select one of even
or odd radio buttons. If she/he selects odd, check the odd positions in the word
entered, if they all contain vowels, then display the message ‘You win’, else
display ‘You lose’. Similarly, if the user selects even, check for vowels in all
even positions in the word entered. Use jstl’s ‘fn’ library.*/
//!!! Resource @tutorials duniya

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="all" uri="/WEB-INF/tlds/custom.tld" %>

<!DOCTYPE html>
<html>
	<head>
		<title>JSP Program 5 Tutorialsduniya.com</title>
	</head>
	<body>
		<c:set var="a" value="${param.vowel}"/>
		<c:set var="b" value="${param.evod}"/>
		<c:set var="c" value="${fn:split(a , '')}"/>
		<c:choose>
			<c:when test="${b=='odd'}">
				<c:forEach begin="1" end="${c}" var="k" step="2">
					<c:if test="${c[k]=='a'|| c[k]=='e'|| c[k]=='i'|| c[k]=='o'|| c[k]=='u'}">
					</c:if>
				</c:forEach>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</body>
</html>
