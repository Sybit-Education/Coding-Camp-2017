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
    <img src=${locationImg} class="center-block img-responsive header-img" alt="Responsive image">
</div>    
   
 <div class="container"> 
     
    <div class="page-header">
      <h1>${quizName}</h1>
    </div>

    <p class="text-field">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    
    
    <b class="text-field">Wähle eine richtige Antwort aus.</b>
    
     
    <div class="text-field">
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
    
    
        <p class="text-field"><b>Prüfe deine ausgewählte Antwort!</b><br> 
    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
    
    
 </div>
    
<c:import url="include/navbar-bottom.jsp"/>

<c:import url="include/footer.jsp"/>
</body>

</html>