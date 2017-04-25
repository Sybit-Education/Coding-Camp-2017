<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
  
<div class="map-smal" id="map">Hier entsteht eine schmale Map-Ansicht für die Location-Seiten</div>

<div>
    <img src="${locationImg}" class="img-responsive header-img" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
     
        <a href="<c:url value="/quiz" />"><center><button type="button" class="btn btn-default button-space">Quiz Starten</button></center></a>
 

     
     <div class="page-header text-field">
         <center><h1>${locationName}</h1></center>
    

      <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    </div>
      
        <a href="<c:url value="/quiz" />"><center><button type="button" class="btn btn-default button-space">Quiz Starten</button></center></a>
       
       
        <p class="text-field"><b>Jetzt Quiz starten, Punkte sammeln und Prämien erhalten</b> 
       Hier kommt die Beschreibung zum Gewinnspiel.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.</p>
       
       
        <a href="<c:url value="/datenschutz" />"><center><button type="button" class="btn btn-default button-space">Location-Übersicht</button></center></a>
       
</div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>