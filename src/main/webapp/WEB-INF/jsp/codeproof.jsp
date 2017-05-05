<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
    
<head>
<c:import url="include/head.jsp"/>
</head>


<body>
<c:import url="include/navigation.jsp"/>
      
<div>
    <img src="${locationImg}" class="img-responsive header-img" alt="Responsive image">
</div>
   
 <div class="container"> 
     
    <div class="page-header">
        <h1>Finde den Code der Location Michwerk</h1>
    </div>

    <p class="text-field">Der Code ist erforderlich, um das Quiz starten zu können.</p>
        
    <form class="form-inline">
        <div class="form-group">
        <label class="sr-only">Code eingeben</label>
        <input type="email" class="form-control" placeholder="Code eingeben">
        </div>
        <center><a href="#"><button type="button" class="btn btn-default button-space">Code prüfen</button></a></center>
    </form>
        
        
    <dl class="text-field">
        <dt>Hopla!</dt> 
        <p>Der Code ist nicht lesbar oder ist nicht mehr vorhanden? Dann rufe den Hinweis auf.
        <dt>Aber Achtung!</dt>
        <p>Hierfür werden dir 50 Punkte abgezogen.
        </p>
    </dl>
    
    
    <center><a href="#"><button type="button" class="btn btn-default button-space">Zum Hinweis</button></a></center>
    
    
 </div> 
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>