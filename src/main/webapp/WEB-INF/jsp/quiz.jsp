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

                    <div class="col-xs-12">
                        <button type="submit" class="col-xs-2 btn btn-primary btn-lg " name="antwort" value="1">1 </button> 
                        <div class="col-xs-10">${frage.antwort1}</div>
                    </div>
                    <br>
                    <div class="col-xs-12">
                        <button type="submit" class="col-xs-2 btn btn-primary btn-lg " name="antwort" value="2">2 </button> 
                        <div class="col-xs-10">${frage.antwort2}</div>
                    </div>
                    <br>
                    <div class="col-xs-12">                    
                        <button type="submit" class="col-xs-2 btn btn-primary btn-lg " name="antwort" value="3">3 </button> 
                        <div class="col-xs-10">${frage.antwort3}</div>
                    </div>
                </form>

            </div>

        </div>

        <c:import url="include/footer.jsp"/>
    </body>

</html>