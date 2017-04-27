<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
  
<div class="map-small" id="map"></div>

<div>
    <img src="${locationImg}" class="img-responsive header-img" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
     
        <center><a href="<c:url value="/codeproof" />"><button type="button" class="btn btn-default button-space">Quiz Starten</button></a></center>
 

     
     <div class="page-header text-field">
         <center><h1>${locationName}</h1></center>
    
      <p>${locationBeschr}</p>

       <div>
           <center><a href="<c:url value="/codeproof" />"><button type="button" class="btn btn-default button-space">Quiz Starten</button></a></center>
       </div>
       
       <p class="text-field"><b>Jetzt Quiz starten, Punkte sammeln und Praemien erhalten</b> 
       Hier kommt die Beschreibung zum Gewinnspiel.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.
       </p>
       
       <div>
           <center><a href="<c:url value="/datenschutz" />"><button type="button" class="btn btn-default button-space">Location-Uebersicht</button></a></center>
       </div>
</div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>