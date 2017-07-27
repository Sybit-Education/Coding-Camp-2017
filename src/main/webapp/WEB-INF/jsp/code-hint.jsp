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

            <!-- TODO: Code Hinweis für eine Location anzeigen -->

            <!-- TODO: Button zur Codeeingabe bereitstellen und auf <c:url value="/location/${locationSlug}/code"/> verlinken -->

            <!-- TODO: Formular auf "/location/${locationSlug}/code/check" abschicken, falls kein code vorhanden/gefunden -->

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
