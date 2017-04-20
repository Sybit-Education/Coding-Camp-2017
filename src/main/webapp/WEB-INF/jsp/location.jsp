<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
  
<div class="embed-responsive embed-responsive-16by9">
  <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2683.130894058282!2d8.969232315793843!3d47.74011497919381!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x479a61e89ba4d95b%3A0x7acd8ecb1ddcfdfb!2sSybit+GmbH!5e0!3m2!1sde!2sde!4v1489999736684" width="600" height="200" frameborder="0" style="border:0" allowfullscreen></iframe>
</div>

<div>
    <img src=${locationImg} class="center-block img-responsive" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
     <div class="page-header">
        <h1>${locationName}</h1>
    </div>

      <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
        </p>

       <div>
           <a href="<c:url value="/quiz" />"><center><button type="button" class="btn btn-default">Quiz Starten</button></center></a>
       </div>
       
       <b>Jetzt Quiz starten, Punkte sammeln und Prämien erhalten</b> 
       <p>Hier kommt die Beschreibung zum Gewinnspiel.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.
       </p>
       
       <div>
           <a href="<c:url value="/datenschutz" />"><center><button type="button" class="btn btn-default">Location-Übersicht</button></center></a>
       </div>
</div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>