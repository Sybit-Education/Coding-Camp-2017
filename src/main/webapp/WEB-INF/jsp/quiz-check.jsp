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
                <h1>${locationName}</h1>
            </div>

            <!-- TODO: Ausgeben ob die Antwort korrekt war -->
            <!-- Hint: #AntwortRichtig, #AntwortFalsch, #FragenAuswahl

            <!-- TODO: Korrekte Antwort der Location in einem Alert ausgeben -->

            <!-- TODO: Onclick-Funktionen bei den Buttons einbinden und die Links zu den Ãœbersichten eintragen -->
            <div class="col-xs-6 col-md-4"><a href="#"><button type="button" class="btn btn-default text-field">Location-Übersicht</button></a></div>
            <div class="col-xs-6 col-md-4"><a href="#">"><button type="button" class="btn btn-default text-field">MyScore-Übersicht</button></a></div>

        </div>

        <c:import url="include/footer.jsp"/>
    </body>
    
</html>