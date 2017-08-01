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

            <!-- Eingabe für den Code -->

            <form method="POST" action="<c:url value="/location/${location.getSlug()}/code-check" />">
                <input type="text" name="code" />
                <input  type="submit" value="code" />
            </form>
            
            <!-- Code Hinweis behandeln -->


            <!-- Am besten ein Button der ein Modal aufruft um den User auf den Punkteverlust hinzuweisen -->




        </div> 
        <!-- Modal das den User warnt -->



        <c:import url="include/footer.jsp"/>
    </body>

</html>