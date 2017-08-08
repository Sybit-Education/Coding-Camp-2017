<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <title>Frage zu ${location.name} | R750Explorer</title>
    </head>

    <body>


        <div class="container"> 

            <div class="page-header">
                <h1>Frage zu ${location.name}</h1>
            </div>


            <div class="row">
                <div class="col-xs-12">
                    <b>${frage.getFrage()}</b>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">                
                    <p>Wähle eine richtige Antwort aus.</p>
                </div>
                <form action="<c:url value="/location/${location.slug}/quiz/check"/>" method="POST">
                    <input type="hidden" name="fragenID" value="${frage.getId()}">

                    <div class="container-fluid">
                        <button type="submit" class=" frage alert alert-info" name="antwort" value="1">${frage.antwort1}</button> 
                    </div>

                    <div class="container-fluid">
                        <button type="submit" class="frage alert alert-info"  name="antwort" value="2">${frage.antwort2}</button> 
                    </div>

                    <div class="container-fluid">                    
                        <button type="submit" class="frage alert alert-info"  name="antwort" value="3">${frage.antwort3}</button> 
                    </div>
                </form>

            </div>

        </div>

        <c:import url="include/footer.jsp"/>
    </body>

</html>