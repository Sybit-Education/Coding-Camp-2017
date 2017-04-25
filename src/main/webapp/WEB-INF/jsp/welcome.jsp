<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="de">
<head>
  <c:import url="include/head.jsp"/>
</head>
<body>
<c:import url="include/navigation.jsp"/>

<div class="map-big" id="map"></div>      
<div class="container text-field"> 

<h1>Erleben-Wissen-Punkten</h1>

<p><b>Beschreibung</b><br> 
Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.Hier entsteht ein Beschreibungstext.
</p>

 <a href="<c:url value="location" />">Location...</a>
</div>


<script>

    $(document).ready(function(){

        var response;

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
            console.log(response[13]["Geo-Lat"]);

            for(var i = 0; i < response.length; i++){
                markers.push(new google.maps.Marker({
                    position: {lat: response[i]['Geo-Lat'], lng: response[i]['Geo-Lng']},
                    map: map,
                    title: response[i].Name,
                    url:'http://www.sybit.de/'
                }));
            }

            console.log(markers);

        }




    });

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

<c:import url="include/navbar-bottom.jsp"/>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJuUkhivatfWJONIXbqYPGhdJuqhOh_9M&callback=initMap"></script>

<c:import url="include/footer.jsp"/>

</body>

</html>