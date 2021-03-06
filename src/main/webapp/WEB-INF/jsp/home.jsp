<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="de">
    <head>
        <c:import url="include/head.jsp"/>
        <!-- special css for home -->
        <link rel="stylesheet" href="<c:url value="/resources/css/addtohomescreen.min.css" />" />
        <meta name="description" content="R750Explorer: Entdecke Radolfzell und gewinne tolle Preise!" />
        <title>R750Explorer</title>
    </head>

    <body>
        <div class="map-big" id="map"></div> 

        <div class="container">
            <h1>R750Explorer - Entdecke Radolfzell!</h1>
            <c:if test="${not empty message}">
                <div class="alert alert-info alert-dismissable">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <p>${message}</p>
                </div>
            </c:if>
            
            <p>
                Entdecke Radolfzell auf eine neue Weise, sammle Punkte und gewinne tolle Preise!
            </p>
            
            <div class="row">
                <div class="col-xs-12">
                    <h2>Alle Ziele</h2>
                </div>
            </div>
            
            <div class="row row-horizon">
                <c:forEach items="${locations}" var="location" varStatus="loop">
                    <c:if test="${location.status == 'aktiv'}">


                        <a href="<c:url value="/location/${location.slug}"/>" class="col-xs-6 col-md-4">
                            <div class="panel panel-default bootcards-media" >
                                <img src="${location.photo[0].thumbnails.large.url}" class="img-responsive cards"/>
                                <c:if test="${location.visited==true}">
                                    <div class="locationBadge"><b>Schon besucht!</b></div> 
                                </c:if>
                                <div class="panel-footer">
                                    <small>${location.name}</small>
                                </div>
                            </div>
                        </a>

                    </c:if>
                </c:forEach>
            </div>
            
            <div class="row">
                <div class="col-xs-12">
                    <h2>Die Gewinne des Monats</h2>
                </div>
            </div>
            
            <div class="row row-horizon">
                <c:forEach items="${gewinne}" var="gewinn" varStatus="loop">
                    <div  class="col-xs-6 col-md-4" >
                        <a href="<c:url value="/gewinne" />">
                            <div class="panel panel-default bootcards-media" >
                                <img src="${gewinn.foto[0].thumbnails.large.url}" class="img-responsive cards"/>

                                <div class="panel-footer">
                                    <small>${gewinn.name}</small>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <p style="padding-top:10px">Viel Spaß beim Erforschen der Stadt Radolfzell.</p>
                </div>
            </div>


            <c:import url="include/footer.jsp"/>

            <!-- Google Maps API-->
            <script async defer type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCwHJF6ylQn14T9jTRmbzbBuYsDL5PMoIs&callback=initMap"></script>
            <!-- For Mobile -->
            <script type="text/javascript" src="<c:url value="/resources/js/addtohomescreen.min.js" />"></script>

            <script type="text/javascript">
                $(document).ready(function () {

                    addToHomescreen({
                        detectHomescreen: true
                    });

                });
            </script>
    </body>
</html>
