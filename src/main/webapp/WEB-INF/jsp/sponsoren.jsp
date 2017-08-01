<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="de">

    <head>
        <c:import url="include/head.jsp"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
        <title>Sponsoren | R750Explorer</title>
    </head>
    <body>

        <div class="container">

            <!-- TODO: Danksagung an die Sponsoren (Name, Beschreibung, Logo enzeigen lassen)  -->
            <div>
                <c:forEach items="${sponsoren}" var="sponsor" varStatus="loop">
                    <div class="col-md-2">
                        <img src="${sponsor.logo[0].thumbnails.large.url}" class="img-responsive cards"/>
                    </div>
                </c:forEach>
            </div>
            

        </div>

        <c:import url="include/footer.jsp"/>
    </body>
</html>