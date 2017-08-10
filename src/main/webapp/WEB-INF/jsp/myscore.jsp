<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <title>Highscore | R750Explorer</title>
    </head>
    <body>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" >Registrierung</h4>
                    </div>
                    <!--register action will enable the create and add the user in UserList-->
                    <form action="<c:url value="/register"/>" method="POST">
                        <div class="modal-body">
                            <!--Username(Nickname) and the email adress required-->
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Nickname<sup>*</sup>:</label>
                                <input type="text" class="form-control" name="nickname" placeholder="Nickname fuer Highscore" min="4" max="16" maxlength="16">
                                <p>Der Nickname wird in der Highscoretabelle angezeigt.</p>
                            </div> 
                            <div>
                                Folgende Daten sind zur Gewinnermittlung notwendig und werden nicht ver&oumlffentlicht:
                            </div>
                            <div class="form-group">
                                <label for="message-text" class="form-control-label">E-Mail<sup>*</sup>:</label>
                                <input type="text" class="form-control" name="email" placeholder="E-Mail">
                            </div>  
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Vorname:</label>
                                <input type="text" class="form-control" name="vorname" placeholder="Vorname">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Nachname:</label>
                                <input type="text" class="form-control" name="nachname" placeholder="Nachname">
                            </div>

                            <div>
                                <sup>*</sup> Pflichtfelder

                            </div>
                            <!---button Submit sends the User Values and registers, else Cancels-->
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Abbrechen</button>
                            <a href="<c:url value="/register"/>"
                               onClick="ga('send', 'event', 'Registrieren', 'send');">
                                <button type="submit" class="btn btn-primary">Registrieren</button>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div class="container"> 

            <div class="page-header">
                <h1 class ="text-left" >Highscore</h1>

                <div class="score" style="display: inline-block">
                    <h4>
                        Dein aktueller Punktestand: <b><fmt:formatNumber type = "number" value = "${Punkte}"/></b>
                    </h4>
                </div>


                <center>
                    <c:choose>
                        <c:when test = "${Badge == 1}">
                            <img src="<c:url value="/resources/images/bronze128x128.png" />" width="25%">
                        </c:when>
                        <c:when test = "${Badge == 2}">
                            <img src="<c:url value="/resources/images/silber128x128.png" />" width="25%">
                        </c:when>
                        <c:when test = "${Badge == 3}">
                            <img src="<c:url value="/resources/images/gold128x128.png" />" width="25%">
                        </c:when>
                        <c:when test = "${Badge == 0}"></c:when>
                    </c:choose>
                </center> 
                <!-- Benachrichtigungen an den User bei registrierungsproblemen -->
                <c:if test="${not empty message}">
                    <div class="alert alert-info alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <p>${message}</p>
                    </div>
                </c:if>


                <div class="row">
                    <div class="col-xs-12">
                    <c:choose>
                        <c:when test="${register == false}">
                            <p>Um einen der Preise gewinnen zu können, musst Du dich in der Highscore mit deinen Punkten registrieren:</p>
                            <button type="button" 
                                    data-toggle="modal" data-target="#myModal" class="btn btn-default"
                                    onClick="ga('send', 'event', 'Registrieren', 'open');">Highscore registrieren</button>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/update"/>">
                                <button type="button" class="btn btn-default"
                                        onClick="ga('send', 'event', 'Registrieren', 'update');">Highscore aktualisieren</button>
                            </a>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>

            </div>
                   
            <div class="row">                

                <div class="row col-xs-12 col-sm-9 col-md-6">
                    <div class="col-xs-4 text-center"><b>Bronze</b>
                     <img src="<c:url value="/resources/images/bronze128x128.png" />" class="img-responsive" alt="Code Sticker Bronze" />
                     22-70 Punkte
                    </div>
                    <div class="col-xs-4 text-center"><b>Silber</b>
                     <img src="<c:url value="/resources/images/silber128x128.png" />" class="img-responsive" alt="Code Sticker Silber" />
                     71-120 Punkte
                    </div>
                    <div class="col-xs-4 text-center"><b>Gold</b>
                     <img src="<c:url value="/resources/images/gold128x128.png" />" class="img-responsive" alt="Code Sticker Gold" />
                     über 120 Punkte
                    </div>
                </div> 
            </div>
            <div class="row">                      
                <div class="col-xs-12 col-sm-9 col-md-6">
                    <!-- Die Highscoretabelle -->
                    <table class="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th></th>
                                <th width="70%">Nickname</th>
                                <th>Punkte</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${Liste}" var="score" varStatus="loop">
                                <tr >
                                    <th scope="row" class="text-right">${loop.index +1}</th>
                                    <td class="text-right">
                                        
                                        <c:choose>
                                            <c:when test = "${score.badge == 1}">
                                                <img src="<c:url value="/resources/images/bronze128x128.png" />" width="30px">
                                            </c:when>
                                            <c:when test = "${score.badge == 2}">
                                                <img src="<c:url value="/resources/images/silber128x128.png" />" width="30px">
                                            </c:when>
                                            <c:when test = "${score.badge == 3}">
                                                <img src="<c:url value="/resources/images/gold128x128.png" />" width="30px">
                                            </c:when>
                                            <c:when test = "${score.badge == 0}"></c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        ${score.nickname}
                                    </td>
                                    <td class="text-right">
                                        <fmt:formatNumber type = "number" value = "${score.score}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div> 
        </div>

        <c:import url="include/footer.jsp"/>
    </body>
</html>
