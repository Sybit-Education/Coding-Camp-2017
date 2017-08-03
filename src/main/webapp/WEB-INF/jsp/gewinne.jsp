<%-- 
    Document   : gewinne
    Created on : 03.08.2017, 10:34:52
    Author     : kessler-b3b3
    Author     : bubin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gewinne</title>
    </head>
    <body>
    <c:forEach items="${gewinne}" var="gewinn" varStatus="loop">
            a
    </c:forEach>

    <c:import url="include/footer.jsp"/>
</body>
</html>
