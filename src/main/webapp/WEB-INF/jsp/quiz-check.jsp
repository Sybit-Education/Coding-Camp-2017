<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    <head>
        <c:import url="include/head.jsp"/>
        <title>Lösung für ${locationName} | R750Explorer</title>
    </head>
    <body>

        <div class="container"> 

            <div class="page-header">
                <h1>Lösung für ${location.name}</h1>
            </div>
            <c:choose>
                <c:when test="${loesung == 'true'}">
                    <div> 
                        <b>Super! Du hast die <b style="color: green">richtige Lösung</b> eingegeben! 
                            Hier kannst du die richtige Lösung nochmal nachlesen:</b>
                    </div>

                </c:when>
                <c:otherwise>
                    <div> 
                        <b>Schade, das war leider die <b style="color: red">falsche Antwort</b>. :( 
                            Hier kannst du die richtige Antwort nachlesen:</b>
                    </div>
                </c:otherwise>
            </c:choose>
            </br> 
            <div class="well well-sm"><i class="fa fa-lightbulb-o" aria-hidden="true"></i>${loesungText}</div>

            <div class="col-xs-12">Gehe zur Übersicht und suche den nächsten Ort!</div>
            
            <div class="col-xs-6 col-md-4"><a href="<c:url value="/"/>">
                    <button type="button" class="btn btn-default text-field">Übersicht</button></a>
            </div>
            <div class="col-xs-6 col-md-4"><a href="<c:url value="/myscore"/>">
                    <button type="button" class="btn btn-default text-field">Punkte</button></a>
            </div>

        </div>

        <c:import url="include/footer.jsp"/>
    </body>

</html>