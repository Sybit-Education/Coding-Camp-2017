<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
    </head>

    <body>


        <div class="container"> 

            <div class="page-header">
                <h1>${location.name}</h1>
            </div>



            <b>${frage.getFrage()}</b>

            <p>Wähle eine richtige Antwort aus.</p>


            <form action="<c:url value="/location/${location.slug}/quiz/check"/>" method="POST">
                <input type="hidden" name="fragenID" value="${frage.getId()}">
                
                <div class="row">
                    <button type="submit" class="col-xs-2 btn btn-primary btn-lg " name="antwort" value="1">1 </button> <div class="col-xs-10">${frage.antwort1}</div>
                </div>
                <br>
                <div class="row">
                    <button type="submit" class="col-xs-2 btn btn-primary btn-lg " name="antwort" value="2">2 </button> <div class="col-xs-10">${frage.antwort2}</div>
                </div>
                <br>
                <div class="row">                    
                    <button type="submit" class="col-xs-2 btn btn-primary btn-lg " name="antwort" value="3">3 </button> <div class="col-xs-10">${frage.antwort3}</div>
                  
                </div>
            </form>

        </div>


        <c:import url="include/footer.jsp"/>
    </body>

</html>