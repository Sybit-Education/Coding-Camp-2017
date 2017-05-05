<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
      

   
 <div class="container"> 
     
    <div class="page-header">
        <h1>Dein Punktestand</h1>
    </div>

    <p class="text-field">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. 
    </p>
    
    <img src="resources/images/score.jpg" class="center-block img-responsive text-field" alt="Responsive image">
    
    <center><a href="<c:url value="/" />"><button type="button" class="btn btn-default">Location-Uebersicht</button></a></center>
    
     
</div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>