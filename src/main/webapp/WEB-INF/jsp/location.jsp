<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <title>${locationName} | R750Explorer</title>
    </head>


    <body locationSlug="${locationSlug}"> 
     
        <div class="container">
              <div class="map">
                 <img src="${locationFoto}" class="img-responsive img-rounded"/>
             </div>
            <div class="page-header"><h1>${locationName}</h1></div>
            ${locationDescription}
            <c:if test="${QuizAnswered==false}">
                <div class="text-field">
                    <center><a href="<c:url value="/location/${locationSlug}/code"/>"><button typ="button" class="btn btn-default">Quiz starten</button></a></center>
                </div>
            </c:if>
 
            <c:forEach items="${locationMedien}" var="media" varStatus="loop">
                <div class="row">
                    <c:if test="${media.type=='Foto'}">
                        <div class="col-xs-12">
                            <img src="${media.attachements[0].url}" class="img-responsive img-rounded">
                            ${media.ueberschrift}
                        </div>
                    </c:if>

                    <c:if test="${media.type== 'Text'}">
                        <div class="col-xs-12">
                            ${media.ueberschrift}
                            <p>${media.text}</p>
                        </div>
                    </c:if> 
                    <c:if test="${media.type== 'Link'}">
                        <div class="col-xs-12">
                            <a href="${media.link}" target="_blank">
                            <i class="glyphicon glyphicon-link"></i> ${media.ueberschrift}
                            </a>
                        </div>
                    </c:if>
                </div>
                <div class="row">&nbsp;</div>
            </c:forEach>
               
        
        <c:import url="include/footer.jsp"/>

    </body>

</html>
