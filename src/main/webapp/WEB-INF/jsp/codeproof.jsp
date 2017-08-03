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
            
            <h3 class="col-xs-12">Codeeingabe</h3>
            <!-- Eingabe für den Code -->
            <c:choose>
                <c:when test="${maxEntries == 'true'}">
                    <p class="col-xs-12 text-center">
                        Du hast leider zu oft einen falschen Code eingegeben.
                    </p>
                    <div class="col-xs-12 text-center">
                        <div><i class="fa fa-frown-o" style="font-size: 200px;" aria-hidden="true"></i></div>
                        <div><a href="<c:url value="/location/${location.getSlug()}"/>"><button  type="button" class="btn btn-default">Zurück zu ${location.getName()}</button></a></div>
                    </div>
                </c:when>
                <c:otherwise>
                 <form method="POST" action="<c:url value="/location/${location.getSlug()}/quiz"/>">
                    <input type="hidden" name="hint" value="false" />
                    <input type="text" name="code" />
                    <input  type="submit" value="code" />
                </form>
                <a href="<c:url value="/location/${location.getSlug()}/code/hint"/>"><button type="button" class="btn btn-default btn-xs">Hinweis zum Code</button></a>

                </c:otherwise>
            </c:choose>
            <!-- Code Hinweis behandeln -->


            <!-- Am besten ein Button der ein Modal aufruft um den User auf den Punkteverlust hinzuweisen -->




        </div> 
        <!-- Modal das den User warnt -->



        <c:import url="include/footer.jsp"/>
    </body>

</html>