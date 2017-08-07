<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">


    <head>
        <c:import url="include/head.jsp"/>
    </head>


    <body>

        <div class="container"> 

            <div class="page-header">
                <h1>${locationName}</h1>

            </div>
            <c:choose>
                <c:when test="${loesung == 'true'}">
                    <div> <b>Super! Du hast die <b style="color: red">richtige Lösung</b> eingegeben! Hier kannst du die richtige Lösung nochmal nachlesen:</b></div>

                </c:when>
                <c:otherwise>
                    <div> <b>Schade, dass war leider die <b style="color: red">falsche Antwort</b>. :( Hier kannst du die richtige Antwort nachlesen:</b></div>
                </c:otherwise>
            </c:choose>
            </br> 
            <div class="well well-sm">${loesungText}</div>

            <div class="col-xs-6 col-md-4"><a href="<c:url value="/"/>"><button type="button" class="btn btn-default text-field">Location-Übersicht</button></a></div>
            <div class="col-xs-6 col-md-4"><a href="<c:url value="/myscore"/>"><button type="button" class="btn btn-default text-field">MyScore-Übersicht</button></a></div>

        </div>

        <c:import url="include/footer.jsp"/>
    </body>

</html>