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

 <a href="<c:url value="location" />">Location...</a>
</div>


<script>

    function initMap() {


        $(document).ready(function(){

            var response;

            var sybit = {lat: 47.740115, lng: 8.971420999999964};

            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 16,
                center: sybit
            });

            $.ajax({
                url: '<c:url value="/location/all"/>',
                type: 'GET',
                success: function(res) {
                    response = $.parseJSON(res);
                    console.log(res);
                    createMarker(response);
                },
                error: function(){
                    response = null;
                    console.log("Error loading Location Data!")
                }
            });

            function createMarker(response){

                var markers = [];

                for(var i = 0; i < response.length; i++){
                    console.log(response[i]["Geo-Lat"]);
                    console.log(response[i]["Geo-Lng"]);

                    markers.push(new google.maps.Marker({
                        position: {lat: parseFloat(response[i]['Geo-Lat']), lng: parseFloat(response[i]['Geo-Lng'])},
                        map: map,
                        title: response[i].Name,
                        url: <c:url value="/location/"/>+response[i]["Slug"]
                    }));

                    google.maps.event.addListener(markers[i], 'click', function() {
                        window.location.href = this.url;
                    });
                }

                console.log(markers);

            }
        });
    }






</script>

<c:import url="include/navbar-bottom.jsp"/>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJuUkhivatfWJONIXbqYPGhdJuqhOh_9M&callback=initMap"></script>

<c:import url="include/footer.jsp"/>

</body>

</html>