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
                
                <h1>${location.getName()}</h1>
            </div>

            //Die Frage sollte angezeigt werden</br>
            Frage: ${frage.getFrage()}
            <h3> </h3>

            <b class="text-field">Wähle eine richtige Antwort aus.</b>


            <form action="<c:url value="/location/${location.slug}/quiz/check"/>" method="POST">
                <input type="hidden" name="fragenID" value="${Frage.getId()}">
                <div class="container-fluid">
                    <div class="container-fluid">

                        //Es sollte für jede Antwortmöglichkeit der Frage ein Button erzeugt werden!

                    </div>

                </div>

            </form>


        </div>


        <c:import url="include/footer.jsp"/>
    </body>

</html>