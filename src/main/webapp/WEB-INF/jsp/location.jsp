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
    <img src=${locationImg} class="center-block img-responsive alt="Responsive image">
</div>    
   
 <div class="container"> 
     
     <div class="page-header">
        <h1>${locationName}</h1>
    </div>

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