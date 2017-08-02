<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
    </head>


    <body>

        <!-- Teile dem User mit das er jetzt registriert wurde -->
        ${message}
        
        <c:import url="include/footer.jsp"/>
    </body>

</html>
