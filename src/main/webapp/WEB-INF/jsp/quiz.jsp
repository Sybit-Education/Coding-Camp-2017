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
      <h1>${quizName}</h1>
    </div>

    <div id="AntwortPruefenErklaerung"><p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    </div>
    
    
    <b>Wähle eine richtige Antwort aus.</b>
    
    <br>
     
    <div id="AntwortButton">
        <div class="alert alert-info" role="alert" >
            <a href="<c:url value="/quiz-check" />" class="alert-link">Antwortmöglichkeit 1</a>
        </div>
        <div class="alert alert-info" role="alert">
            <a href="<c:url value="/quiz-check" />" class="alert-link">Antwortmöglichkeit 2</a>
        </div>
        <div class="alert alert-info" role="alert">
            <a href="<c:url value="/quiz-check" />" class="alert-link">Antwortmöglichkeit 3</a>
        </div>
    </div>
    
    
    <div id="AntwortPruefenErklaerung"><b>Prüfe deine ausgewählte Antwort!</b> 
        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    </div>
    
    
 </div>
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>