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
            <img src="${locationFoto}" class="img-resposive"/>
        </div>
        <div class="container">

            <div class="page-header"><h1>${locationName}</h1></div>
            <c:if test="${QuizAnswered==false}">
                <div class="text-field">
                    <center><a href="<c:url value="/location/${locationSlug}/code"/>"><button typ="button" class="btn btn-default">Quiz starten</button></a></center>
        </div>
            </c:if>
 
            <c:forEach items="${locationMedien}" var="media" varStatus="loop">
                <c:if test="${media.type=='Foto'}">
                    <img src="${media.attachements[0].url}" class="img-resposive"/>
                </c:if>
           
                <c:if test="${media.type== 'Text'}">
                    <div class="container">
                        <p>${media.text}</p>
                    </div>
                </c:if>
                <c:if test="${media.type== 'Link'}">
                    <div class="container">
                        <a href="${media.link}" target="_blanck">
                            <i class="glyphicon glyphicon-link"></i>
                        </a>
                    </div>
                </c:if>
            </c:forEach>
               
        
        <c:import url="include/footer.jsp"/>

    </body>

</html>