<%-- 
    Document   : gewinne
    Created on : 03.08.2017, 10:34:52
    Author     : kessler-b3b3
    Author     : bubin
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <c:import url="include/head.jsp"/>
        <!-- special css for home -->
        <link rel="stylesheet" href="<c:url value="/resources/css/addtohomescreen.min.css" />" />
        <meta name="description" content="R750Explorer: Entdecke Radolfzell und gewinne tolle Preise!" />
        <title>Gewinne | R750Explorer</title>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Gewinne des Monats</h1>

                <p>Alle Preise, die diesen Monat gewonnen werden können:</p>
            </div>
            
            <div class="row">
                <!-- Gewinne des aktuellen Monats -->
                <c:forEach items="${gewinne}" var="gewinn" varStatus="loop">
                    <div class="well well-sm">
                        <div class="row">
                            <div class="col-xs-12">
                                <h2>${gewinn.name}</h2>
                            </div>
                        </div></br>

                        <div class="row">
                            <div class="col-xs-6">
                                ${gewinn.bemerkung}
                            </div>

                            <div class="col-xs-6">
                                <img class="img-thumbnail" src="${gewinn.foto[0].url}" />
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- Gewinne über das ganze Jahr -->
            <div class="row">
                <h1>Alle Gewinne</h1>
                <p>Dies sind alle Gewinne, die in den folgenden Monaten noch zu gewinnen sind.</p>
            </div>
            
            <div class="row row-horizon">
                <c:forEach items="${allGewinne}" var="weitererGewinn" varStatus="loop" >
                    <div  class="col-xs-6 col-md-4" >
                        <div class="panel panel-default bootcards-media" >
                            <img src="${weitererGewinn.foto[0].thumbnails.large.url}" class="img-responsive cards"/>

                            <div class="panel-footer">
                                <small>${weitererGewinn.name}</small>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <c:import url="include/footer.jsp"/>
    </body>
</html>
