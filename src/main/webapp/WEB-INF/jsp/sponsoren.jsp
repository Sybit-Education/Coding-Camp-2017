<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <title>Sponsoren | R750Explorer</title>
    </head>
    <body>
        <div>

        </div>
        <div class="container">
            <div class="page-header">
                <h1>Unsere Sponsoren</h1>
                <p>
                    Wir danken unseren Sponsoren für Ihre Unterstützung mit 
                    Sachpreisen und Materialien für das Projekt:
                </p>               
            </div>

            <c:forEach items="${sponsoren}" var="sponsor" varStatus="loop">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-12 col-sm-3">
                            <a href="${sponsor.link}" target="_blank" >
                                <img class="img-thumbnail" src="${sponsor.logo[0].url}"/>
                            </a>
                        </div>

                        <div class="col-xs-12 col-sm-9">
                            <h3><a href="${sponsor.link}" target="_blank" >${sponsor.name}</a></h3>

                            <p>
                                ${sponsor.description}
                            </p>
                            <p>
                                <a href="${sponsor.link}" target="_blank" >${sponsor.link}</a>
                            </p>
                        </div>
                    </div>
                </div></br>
            </c:forEach>
        </div>
        <c:import url="include/footer.jsp"/>
    </body>
</html>
