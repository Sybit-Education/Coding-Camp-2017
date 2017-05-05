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
        BeschreibungsText
        </p>

    <c:forEach items="${locations}" var="location" varStatus="loop">
        <div class="col-xs-6">
            <div class="text-field" >

                <a href="<c:url value="/location/${location.slug}"/>"><img src="${location.photo[0].url}" class="img-thumbnail"><br>${location.name}</a>
            </div>
        </div>
    </c:forEach>

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