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
            <h1>${location.getName()}:</h1> 
                
                <h2>Code pr�fen</h2>

            <div class ="row">

                <div class="col-xs-12">
                    <form method="POST" action="<c:url value="/location/${location.getSlug()}/quiz"/>">
                    <div class="input-group">
                        <input type="hidden" name="hint" value="false" />
                        <input type="text" class="form-control" name="code" size="6" maxlength="6" placeholder="Code eingeben"/>
                        <span class="input-group-btn">
                            <input  type="submit" class="btn btn-default btn-md" value="pr�fen" />
                        </span>
                    </div><!-- /input-group -->      
                    </form>
                </div>
            </div>
        </div>
        

        <div class ="row">
            <div class="col-xs-6">
                Finde den Sticker und gib den sechsstelligen Code ein! Gro�- und Kleinschreibung muss dabei nicht beachtet werden.
            </div>
            <div class="col-xs-6">
                <img src="<c:url value="/resources/images/code-aufkleber.jpg" />" class="img-thumbnail pull-right" alt="Code Sticker" />
            </div> 
 
        </div>
        
        <div class="row">
            <div class="col-xs-12"><h3>Sticker unauffindbar</h3></div>
            <div class="col-xs-12">
                Sticker mit dem Code nicht gefunden? F�r <b>5&nbsp;Punkte Abzug</b> kannst du einen Hinweis bekommen:<br/>
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