<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
  
<div class="map-smal" id="map"></div>

<div>
    <img src="${locationImg}" class="img-responsive header-img" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
     
        <a href="<c:url value="/quiz" />"><center><button type="button" class="btn btn-default button-space">Quiz Starten</button></center></a>
 

     
     <div class="page-header text-field">
         <center><h1>${locationName}</h1></center>
    
      <p>${locationBeschr}</p>

       <div>
           <a href="<c:url value="/quiz" />"><center><button type="button" class="btn btn-default">Quiz Starten</button></center></a>
       </div>
       
       <b>Jetzt Quiz starten, Punkte sammeln und Pr�mien erhalten</b> 
       <p>Hier kommt die Beschreibung zum Gewinnspiel.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.
       </p>
       
       <div>
           <a href="<c:url value="/datenschutz" />"><center><button type="button" class="btn btn-default">Location-�bersicht</button></center></a>
       </div>
</div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>