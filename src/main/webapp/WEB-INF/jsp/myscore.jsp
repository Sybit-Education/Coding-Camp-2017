<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
    </head>


    <body>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <!--registration in form of a "form"-->
                        <h4 class="modal-title" >Registrierung</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <!--register action will enable the create and add the user in UserList-->
                    <form action="<c:url value="/register"/>" method="POST">
                        <div class="modal-body">
                            <!--Username(Nickname) and the email adress required-->
                            <div class="form-group">
                                <label for="recipient-name" class="form-control-label">Nickname:</label>
                                <input type="text" class="form-control" name="nickname">
                            </div>
                            <div class="form-group">
                                <label for="message-text" class="form-control-label">E-Mail:</label>
                                <input type="email" class="form-control" name="email">
                            </div>
                            <!---button Submitt sends the User Values and registers, else Cancels-->
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
                <h1>Dein Highscore: ${Score}</h1>
            </div>
            <div class="col-md-12 col-xs-12">
                <center>
                    <!-- Eine Tabelle der Highscores -->

                    <a href="<c:url value="/" />"><button type="button" class="btn btn-default">Location-Uebersicht</button></a>
                    <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-default">Highscore registrieren</button>

                </center>
            </div>









        </div> 




        <c:import url="include/footer.jsp"/>
    </body>

</html>