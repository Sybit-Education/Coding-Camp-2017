<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <title>${locationName} | R750Explorer</title>
    </head>


    <body locationSlug="${locationSlug}"> 
        <div class="map">
            <img src="${locationPhoto}" class="img-resposive"/>
        </div>
        <div class="container">

            <div class="page-header"><h1>${locationName}</h1></div>
            <c:if test="${QuizAnswered==false}">
                <div class="text-field">
                    <center><a href="<c:url value="/location/${locationSlug}/code"/>"><button typ="button" class="btn btn-default">Quiz starten</button></a></center>
        </div>
            </c:if>
 
            <c:forEach items="${locationMedia}" var="media" varStatus="loop">
            <c:if test="${media.type=='Foto'}">
            <img src="${media.attachement[0].url}" class="img-resposive"/>
            
        <c:import url="include/footer.jsp"/>

    </body>

</html>