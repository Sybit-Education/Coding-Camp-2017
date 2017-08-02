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
            <div class="page-header">
                <div class="row">
                    <div class="col-xs-12">
                        <img src="${locationFoto}" alt="${locationName}" class="img-responsive" />
                        <h1 class="locationTitle">${locationName}</h1>
                    </div>
               </div>
               <div class="row">
                    <p class="col-xs-12">${locationDescription}</p>                        
                    <c:if test="${QuizAnswered==false}">
                        <div class="col-xs-12 text-center">
                            <a href="<c:url value="/location/${locationSlug}/code"/>">
                                <button typ="button" class="btn btn-default">Quiz starten ...</button>
                            </a>
                        </div>
                    </c:if>                   
                    <c:if test="${QuizAnswered==true}">
                        <div class="col-xs-12 alert alert-info">
                            <strong>Du hast an diesem Ort schon eine Frage beantwortet.</strong>
                        </div>
                    </c:if>                    
                </div>        
            </div>            


            <c:forEach items="${locationMedien}" var="media" varStatus="loop">
                <div class="row">
                    <c:if test="${media.type=='Foto'}">
                        <div class="col-xs-12">
                            <img src="${media.attachements[0].url}" alt="${media.ueberschrift}" class="img-responsive img-rounded" />
                            <div class="imageDescription"><b>${media.ueberschrift}</b></div>
                        </div>
                    </c:if>

                    <c:if test="${media.type== 'Text'}">
                        <h3 class="col-xs-12">${media.ueberschrift}</h3>
                        <p class="col-xs-12">${media.text}</p>
                    </c:if> 
                    <c:if test="${media.type== 'Link'}">
                        <div class="col-xs-12">
                            <a href="${media.link}" target="_blank">
                                <i class="glyphicon glyphicon-link"></i> ${media.ueberschrift}
                            </a>
                        </div>
                    </c:if>
                </div>

            </c:forEach>
            <div class="row">&nbsp;</div>
        </div>    



        <c:import url="include/footer.jsp"/>

    </body>

</html>
