<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
      
<div class="container-fluid">
    <img src="holder.js/1440x560" class="center-block img-responsive" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
    <div class="page-header">
        <h1>Dein Punktestand</h1>
    </div>

    <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. 
    </p>
    
    <img src="resources/img/score.jpg" class="center-block img-responsive" alt="Responsive image">
    
    <a href="<c:url value="/" />"><center><button type="button" class="btn btn-default">Location-Übersicht</button></center></a>
    
     
</div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>