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


            <b>Das ist die Testfrage?</b>

            <p class="text-field">Wähle eine richtige Antwort aus.</p>


            <form action="<c:url value="/location/${location.slug}/quiz/check"/>" method="POST">
                <input type="hidden" name="fragenID" value="${Frage.getId()}">
                <div class="container-fluid">
                    <div class="container-fluid">

                        <button type="button" class="btn btn-default" aria-label="Left Align">
                        a, b, c
                        </button>

                    </div>

                </div>

            </form>


        </div>


        <c:import url="include/footer.jsp"/>
    </body>

</html>