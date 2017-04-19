<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
<head>
  <c:import url="include/head.jsp"/>
    <style>
        #map {
            width: 100%;
            height: 400px;
            background-color: grey;
        }
    </style>
</head>
<body>
<c:import url="include/navigation.jsp"/>

      
<div class="container"> 
     
    <div class="page-header">
        <h1>Erleben-Wissen-Punkten</h1>
    </div>

    <div id="map"></div>

<b>Beschreibung</b><br> 
<p>Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.
</p>

<script>
    function initMap() {
        var sybit = {lat: 47.740115, lng: 8.971420999999964};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 16,
            center: sybit
        });

        var marker = new google.maps.Marker({
            position: sybit,
            map: map,
            title: 'Sybit',
            url:'http://www.sybit.de/'
        });
        google.maps.event.addListener(marker, 'click', function() {
            window.location.href = this.url;
        });
    }
</script>

 <a href="<c:url value="location" />">Location...</a>
</div>


<script>

    for(var i = 0; i < 5; i++) {
        var locationNames = new Array();
        locationNames[i] = "${locations[i].name}";
    }

</script>

<c:import url="include/navbar-bottom.jsp"/>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJuUkhivatfWJONIXbqYPGhdJuqhOh_9M&callback=initMap"></script>

<c:import url="include/footer.jsp"/>

</body>

</html>