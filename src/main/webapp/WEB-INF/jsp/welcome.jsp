<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />


    <style>
        #map {
            width: 100%;
            height: 400px;
            background-color: grey;
        }
    </style>
</head>
<body>

<!-- Navbar -->

<div class="container">


    <h3>My Google Maps Demo</h3>
    <h3>${LocationName}</h3>
    <p>${LocationKoord}</p>
    <div id="map"></div>

</div>


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

<script>

    for(var i = 0; i < 5; i++) {
        var locationNames = new Array();
        locationNames[i] = "${locations[i].name}";
    }

</script>


<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJuUkhivatfWJONIXbqYPGhdJuqhOh_9M&callback=initMap"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>