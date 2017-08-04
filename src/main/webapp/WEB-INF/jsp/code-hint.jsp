<%-- 
    Document   : code-hint
    Created on : 23.05.2017, 08:12:55
    Author     : fzr
--%>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
    </head>


    <body>
        <div class="container">

            <div>
                <!-- TODO: Code Hinweis für eine Location anzeigen -->
                <h1>Code Hinweis</h1>
                <h2>${locationName}</h2>
            </div>
            <p>${HinText}</p>
            <c:forEach items="${Hinfoto}" var="Foto" varStatus="loop">

                <a  class="col-xs-6 col-md-4">
                    <div class="panel panel-default bootcards-media" >
                        <img src="${Foto.url}" class="img-responsive cards"/>

                    </div>
                </a>


            </c:forEach>


            <div>
                <p> Code gefunden?</p>
                <a href="<c:url value="/location/${locationSlug}/code"/>"><button  type="button" class="btn btn-default">Code eingeben!</button></a>
                <br>
                <br>
<!-- TODO: Formular auf "/location/${locationSlug}/code/check" abschicken, falls kein code vorhanden/gefunden -->     
                <p>Der Code wurde nicht gefunden oder ist nicht mehr vorhanden.</p>
                <form action="<c:url value= "/location/${locationSlug}/quiz"/>" method="POST">
                    <input type="hidden" class="form-control" id="code" value="${code}" name="code">
                    <input type="hidden" class="form-control" id="mail" value="true" name="mail">
                    <button type="submit" class="btn btn-default">Weiter zum Quiz</button>
                </form>             
                <br>
            </div>




            <!-- TODO: Modal zum Senden einer Nachricht anzeigen lassen, falls code nicht lesbar -->

        </div>

    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Code</h4>
                </div>
                <form action="<c:url value="/location/${locationSlug}/code/hint/message"/>" method="POST">
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="recipient-name" class="form-control-label">Deine Nachricht an uns:</label>
                            <input type="text" class="form-control" name="message">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Abbrechen</button>
                        <button type="submit" class="btn btn-default">Senden</button>
                    </div>
                </form>   
            </div>
        </div>
    </div>

    <c:import url="include/footer.jsp"/>
</body>

</html>
