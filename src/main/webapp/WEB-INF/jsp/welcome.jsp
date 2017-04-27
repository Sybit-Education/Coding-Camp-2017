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

<div class="col-xs-6">
<div class="text-field" ><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>cafe connect</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Hoellturm</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Jahrhundert Bau</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Konzertsegel</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Milchwerk</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Münster</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Narrenbrunnen</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Rathaus</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Seemaxx</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>El Nino</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Stadt Museum</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Stadtbibliothek</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Stadtgarten</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Stadttor</a></div></div>

<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="cafe connect" class="img-thumbnail"><br>Villa Windschief</a></div></div>
<div class="col-xs-6">
<div class="text-field"><a href="#"><img src="resources/thumbnail_welcome.jpg" alt="hoellturm" class="img-thumbnail"><br>Wasserturm</a></div></div>

</div>



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