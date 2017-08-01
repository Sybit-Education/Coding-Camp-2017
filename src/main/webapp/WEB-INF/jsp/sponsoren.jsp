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
        <div>
            <div class="text-center" >
                <h1>Unsere Sponsoren</h1>
            </div>
        </div>
        <div class="container">
            <!-- TODO: Danksagung an die Sponsoren (Name, Beschreibung, Logo enzeigen lassen)  -->
            <c:forEach items="${sponsoren}" var="sponsor" varStatus="loop">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-6">
                            <h3>${sponsor.name}</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="${sponsor.link}" target="_blank" ><img class="img-thumbnail" src="${sponsor.logo[0].url}" class="img-responsive cards"/></a>
                        </div>
                        <div class="col-xs-12">
                            ${sponsor.description}
                        </div>
                    </div>
                </div></br>
            </c:forEach>
        </div>
        <c:import url="include/footer.jsp"/>
    </body>
</html>