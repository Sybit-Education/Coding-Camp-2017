<%-- 
    Document   : gewinne
    Created on : 03.08.2017, 10:34:52
    Author     : kessler-b3b3
    Author     : bubin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gewinne</title>
    </head>
    <body>
        <c:forEach items="${gewinne}" var="gewinn" varStatus="loop">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-9">
                            <a href="${sponsor.link}" target="_blank" >
                                <img class="img-thumbnail" src="${sponsor.logo[0].url}"/>
                            </a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <h3><a href="${sponsor.link}" target="_blank" >${sponsor.name}</a></h3>
                        </div>                        
                        <div class="col-xs-12">
                            <p>
                                ${sponsor.description}
                            </p>
                            <p>
                                <a href="${sponsor.link}" target="_blank" >${sponsor.link}</a>
                            </p>
                        </div>
                    </div>
                </div></br>
            </c:forEach>
        
        <c:import url="include/footer.jsp"/>
    </body>
</html>
