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
    <img src=${locationImg} class="center-block img-responsive" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
    <div class="page-header">
        <h1>${quizCheckName}</h1>
    </div>

    <div id="AntwortRichtig"><p>Herzlichen Glückwunsch! Deine Antwort ist korrekt.</p>
    </div>
    
    
    <div id="AntwortFalsch"><p>Wie schade! Deine Antwort ist leider falsch.</p>
    </div>
    
    
    
    <div id="FragenAuswahl"><p>Die korrekte Anwort lautet:</p>
        
    <div id="AntwortButton">
        <div class="alert alert-info" role="alert">Antwortmöglichkeit 1</div>
        <div class="alert alert-info" role="alert">Antwortmöglichkeit 2</div>
        <div class="alert alert-info" role="alert">Antwortmöglichkeit 3</div>
    </div>
    </div>
    
    <div id="AntwortPruefenErklaerung"><b>Lorem ipsum dolor sit amet.</b> 
        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    </div>
    
       
    <div class="row" id="AntwortPruefenErklaerung">
        <div class="col-xs-6 col-md-4"><a href="<c:url value="/" />"><center><button type="button" class="btn btn-default">Location-Übersicht</button></center></a></div>
        <div class="col-xs-6 col-md-4"><a href="<c:url value="/myscore" />"><center><button type="button" class="btn btn-default">MyScore-Übersicht</button></center></a></div>
    </div>
        
    
 </div>
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>