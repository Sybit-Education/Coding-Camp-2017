<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
    </head>


    <body>

        <div class="container">          
            <div class="page-header">
                <h1>${location.getName()}: Code prüfen</h1>

                <div class ="row">

                    <div class="col-xs-12">
                        <c:set var="message" value="'Code eingeben'"></c:set>
                        <c:if test="${codeCheck==false}">
                            <c:set var="message" value="'Code war falsch'"></c:set>

                        </c:if>
                        <form method="POST" action="<c:url value="/location/${location.getSlug()}/quiz"/>">
                            <div class="input-group">
                                <input type="hidden" name="hint" value="false" />
                                <input type="text" class="form-control" name="code" size="6" maxlength="6"  placeholder=${message}/>
                                <span class="input-group-btn">
                                    <input  type="submit" class="btn btn-default btn-md" value="prüfen" />
                                </span>


                            </div><!-- /input-group -->      
                        </form>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class ="row well well-sm">
                    <div class="col-xs-6">
                        Finde den Sticker und gib den sechsstelligen Code ein!
                    </div>
                    <div class="col-xs-6">
                        <img src="<c:url value="/resources/images/code-aufkleber.jpg" />" class="img-thumbnail pull-right" alt="Code Sticker" />
                    </div> 
                </div>

            </div>

            <div class="row">
                <div class="col-xs-12"><h3>Sticker unauffindbar</h3></div>
                <div class="col-xs-12">
                    Sticker mit dem Code nicht gefunden? Für <b>5&nbsp;Punkte Abzug</b> kannst du einen Hinweis bekommen:<br/>
                </div>
                <div class="col-xs-12 text-center">

                    <a href="<c:url value="/location/${location.getSlug()}/code/hint"/>"><button type="button" class="btn btn-default btn-md">Hinweis zum Code</button></a>
                </div>
            </div>
        </div>



        <!-- Code Hinweis behandeln -->


        <!-- Am besten ein Button der ein Modal aufruft um den User auf den Punkteverlust hinzuweisen -->




    </div> 
    <!-- Modal das den User warnt -->



    <c:import url="include/footer.jsp"/>
</body>

</html>