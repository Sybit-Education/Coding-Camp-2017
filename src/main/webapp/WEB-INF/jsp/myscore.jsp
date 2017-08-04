<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <title>Highscore | R750Explorer</title>
    </head>
    <body>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" >Registrierung</h4>
                    </div>
                    <!--register action will enable the create and add the user in UserList-->
                    <form action="<c:url value="/register"/>" method="POST">
                        <div class="modal-body">
                            <!--Username(Nickname) and the email adress required-->
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Nickname<sup>*</sup>:</label>
                                <input type="text" class="form-control" name="nickname" placeholder="Nickname fuer Highscore">
                                <p>Der Nickname wird in der Highscore angezeigt.</p>
                            </div> 
                            <div>
                                Folgende Daten sind zur Gewinnermittlung notwendig und werden nicht ver&oumlffentlicht:
                            </div>
                            <div class="form-group">
                                <label for="message-text" class="form-control-label">E-Mail<sup>*</sup>:</label>
                                <input type="text" class="form-control" name="email" placeholder="E-Mail">
                            </div>  
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Vorname:</label>
                                <input type="text" class="form-control" name="vorname" placeholder="Vorname">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Nachname:</label>
                                <input type="text" class="form-control" name="nachname" placeholder="Nachname">
                            </div>

                            <div>
                                <sup>*</sup> Pflichtfelder

                            </div>
                            <!---button Submit sends the User Values and registers, else Cancels-->
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Abbrechen</button>
                            <a href="<c:url value="/register"/>"><button type="submit" class="btn btn-primary">Registrieren</button></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div class="container"> 

            <div class="page-header">
                <h1 class = "text-center" >Dein Highscore: </br> <fmt:formatNumber type = "number" value = "${Punkte}"/></h1>
                <center>
                    <!-- Benachrichtigungen an den User bei registrierungsproblemen -->
                    ${message}</br></br>
                    <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-default">Highscore registrieren</button>

                </center>

            </div>
            <div class="col-md-12 col-xs-12">
                <!-- Die Highscoretabelle -->
                <table class="table">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Platzierung</th>
                            <th>Nickname</th>
                            <th>Punkte</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Liste}" var="score" varStatus="loop">
                            <tr>
                                <th scope="row">${loop.index +1}</th>
                                <td>${score.getNickname()}</td>
                                <td><fmt:formatNumber type = "number" value = "${score.getScore()}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div> 
        <c:import url="include/footer.jsp"/>
    </body>

</html>




