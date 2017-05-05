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
    <img src=${locationImg} class="center-block img-responsive" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
    <div class="page-header">
        <h1>${quizCheckName}</h1>
    </div>

    <p class="text-field" id="AntwortRichtig">Herzlichen Glückwunsch! Deine Antwort ist korrekt.</p>
    
    
    <p class="text-field" id="AntwortFalsch">Wie schade! Deine Antwort ist leider falsch.</p>
    
    
    <p class="text-field" id="FragenAuswahl">Die korrekte Anwort lautet:</p>
        
    <div class="text-field">
        <div class="alert alert-info" role="alert">Antwortmöglichkeit 1</div>
        <div class="alert alert-info" role="alert">Antwortmöglichkeit 2</div>
        <div class="alert alert-info" role="alert">Antwortmöglichkeit 3</div>
    </div>
    
    <p  class="text-field" id="FragenAuswahl"><b>Lorem ipsum dolor sit amet.</b> 
    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    
       
    <div class="col-xs-6 col-md-4"><a href="<c:url value="/" />"><button type="button" class="btn btn-default text-field">Location-Übersicht</button></center</a></div>
    <div class="col-xs-6 col-md-4"><a href="<c:url value="/myscore" />"><button type="button" class="btn btn-default text-field">MyScore-Übersicht</button></a></div>
        
    
 </div>
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>