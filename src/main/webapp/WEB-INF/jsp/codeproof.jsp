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
            <h1>${location.getName()}</h1>
        </div>
        
        <div class ="row">
            <form method="POST" action="<c:url value="/location/${location.getSlug()}/quiz"/>">
                <div class="col-xs-12">
                    <div class="input-group">
                        <input type="text" class="form-control" name="code" size="6" maxlength="6" placeholder="Code eingeben"/>
                        <span class="input-group-btn">
                            <input  type="submit" class="btn btn-default btn-md" value="Code prüfen" />
                        </span>
                    </div><!-- /input-group -->
                       
                </div>
            </form>
        </div>
        
        <div class="row">
            <div class="col-lg-6">
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