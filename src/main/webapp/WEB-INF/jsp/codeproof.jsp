﻿<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
    </head>


    <body>

        <div class="container"> 
            <div class="page-header">
                <h1>${location.getName()}:<br/> Code pr�fen</h1>
            
                <c:choose>
                    <c:when test="${maxEntries == 'true'}">
                        <div class="row">
                            <div class="col-xs-12">
                                <p class="col-xs-12 text-center">
                                    Du hast leider zu oft einen falschen Code eingegeben.
                                </p>
                                <div class="col-xs-12 text-center">
                                    <div><i class="fa fa-frown-o" style="font-size: 200px;" aria-hidden="true"></i></div>
                                    <div><a href="<c:url value="/location/${location.getSlug()}"/>"><button  type="button" class="btn btn-default">Zur?ck zu ${location.getName()}</button></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:when>
                    <c:otherwise>
                        <c:set var="message" value="'Code eingeben'"></c:set>
                        <c:if test="${codeCheck==false}">
                            <c:set var="message" value="'Code war falsch'"></c:set>
                        </c:if>
                        <div class="row">
                            <div class="col-xs-12">
                                <form method="POST" action="<c:url value="/location/${location.getSlug()}/quiz"/>">
                                    <div class="input-group">
                                        <input type="hidden" name="hint" value="false" />
                                        <input type="hidden" name="mail" value="true"/>
                                        <input type="text" class="form-control" name="code" size="6" maxlength="6"  placeholder=${message}/>
                                        <span class="input-group-btn">
                                            <input  type="submit" class="btn btn-default btn-md" value="pr?fen" />
                                        </span>
                                    </div>
                               </form>
                            </div>
                        </div>
  
                        <div class ="row">
                            <div class="col-xs-6">
                                Finde den Sticker und gib den sechsstelligen Code ein!
                            </div>
                            <div class="col-xs-6">
                                <img src="<c:url value="/resources/images/code-aufkleber.jpg" />" class="img-thumbnail pull-right" alt="Code Sticker" />
                            </div> 

                        </div>

                        <div class="row">
                            <div class="col-xs-12"><h3>Sticker unauffindbar</h3></div>
                            <div class="col-xs-12">
                                Sticker mit dem Code nicht gefunden? F?r <b>5&nbsp;Punkte Abzug</b> kannst du einen Hinweis bekommen:<br/>
                            </div>
                            <div class="col-xs-12 text-center">

                                <a href="<c:url value="/location/${location.getSlug()}/code/hint"/>"><button type="button" class="btn btn-default btn-md">Hinweis zum Code</button></a>
                            </div>
                            <br/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
    <c:import url="include/footer.jsp"/>
</body>

</html>
