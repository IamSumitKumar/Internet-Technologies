/*4.1: Display Good Morning <uname>, Good Afternoon <uname> or Good Evening <uname>
based on the current time of the day.*/
//!!! Resource @tutorials duniya

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="k" uri="WEB-INF/tlds/gret.tld"%>

<!DOCTYPE html>
<html>
    <k:today name1="${param.name2}"></k:today>
</html>