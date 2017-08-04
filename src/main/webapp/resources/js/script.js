/** 
 * General call if page is completly loaded.
 */
$(document).ready(function () {
    
    console.log("contextPath = '" + contextPath + "'");
  
    
        
    // update scores in navigation bar
    requestAndSetScore();

    // Set a timeout...
    setTimeout(function () {
        // Hide the address bar!
        window.scrollTo(0, 1);
    }, 0);

    var body = document.documentElement;
    if (body.requestFullscreen) {
        body.requestFullscreen();
    } else if (body.webkitrequestFullscreen) {
        body.webkitrequestFullscreen();
    } else if (body.mozrequestFullscreen) {
        body.mozrequestFullscreen();
    } else if (body.msrequestFullscreen) {
        body.msrequestFullscreen();
    }


    if (!cookiesEnabled()) {
        // cookie not worked, set/enable appropriate things
        alert("Ohne Cookies funktioniert die App leider nicht!");
    }
});



function initMap() {
    
    $.ajax({
        url: contextPath +'/location/all',
        type: 'GET',
        success: function (res) {
            response = $.parseJSON(res);
            buildComponents(response);
            setCurrentLocation(map);
        },
        error: function () {
            response = null;
            console.log("Error loading location data!");
        }
    });
}

function buildComponents(allLocations) {
    //Delay to process all Items correct
    //setTimeout(function () {}, 2000);

    var viewpoint = {lat: 47.740115, lng: 8.971420999999964};
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 14,
        center: viewpoint,
        disableDefaultUI: true
    });

    markers = [];
    infoWindows = [];

    createMarkers(allLocations, markers, infoWindows).then(function (returnValue) {
        markers = returnValue[0];
        infoWindows = returnValue[1];

        var bounds = new google.maps.LatLngBounds();

        for (i = 0; i < markers.length; i++) {
            google.maps.event.addListener(markers[i], 'click', function () {
                for (var i = 0; i < infoWindows.length; i++) {
                    if (this === markers[i]) {
                        infoWindows[i].open(map, markers[i]);
                    } else {
                        infoWindows[i].close();
                    }
                }
            });
            bounds.extend({lat: parseFloat(response[i]['Geo-Lat']), lng: parseFloat(response[i]['Geo-Lng'])});
        }
        map.fitBounds(bounds);
    });
}

function createMarkers(allLocations, markers, infoWindows) {

    return new Promise(function (resolve, reject) {

        for (i = 0; i < allLocations.length; i++) {

            contentStringInfoWindow =
                    '<div id="content">' +
                    '<a href=' + contextPath + '/location/' + allLocations[i]["Slug"] + '>\n\
                        <img src=' + '' + allLocations[i]["Foto"][0].url + ' class="img-responsive" width="100%" />\n\
                        <div class="locationName"><b>' + allLocations[i].Name + '</b></div>\n\
                    </a>' +    
                    '</div>';


            markers.push(
                    new google.maps.Marker({
                        position: {lat: parseFloat(allLocations[i]['Geo-Lat']), lng: parseFloat(allLocations[i]['Geo-Lng'])},
                        map: map,
                        icon: getIcon(allLocations[i]),
                        title: allLocations[i].Name,
                        url: contextPath + '/location/' + allLocations[i]["Slug"]
                    })
                    );

            infoWindows.push(
                    new google.maps.InfoWindow({
                        content: contentStringInfoWindow,
                        maxWidth: 200
                    })
                    );
        }

        resolve([markers, infoWindows]);
    });
}

function getIcon(location) {

    var notVisitedIcon = {
        url: contextPath + '/resources/images/map-pin.svg',
        size: new google.maps.Size(34, 60),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 60),
        scaledSize: new google.maps.Size(34, 60)
    };
    var visitedIcon = {
        url: contextPath + '/resources/images/map-pin-visited.svg',
        size: new google.maps.Size(34, 60),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 60),
        scaledSize: new google.maps.Size(34, 60)
    };
    if (location.visited) {
        return visitedIcon;
    } else {
        return notVisitedIcon;
    }
}


/**
 * Set current Location.
 * @param {type} map
 * @returns {undefined}
 */
function setCurrentLocation(map) {

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            var marker = new google.maps.Marker({
                position: pos,
                map: map,
                title: 'aktuelle Position'
            });
            //center to use current position
            map.getBounds().extend(pos);

            return pos;
        }, function () {
            //error
        });
    } else {
        // Browser doesn't support Geolocation
    }
}

/**
 * Get cookie-ID of User.
 * 
 * @returns {getCookieUUID.b|String|Array}
 */
function getCookieUUID() {

    var a = "UUID";
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    b = b ? b.pop() : '';

    return b;
}

/**
 * Set Score in navigation bar.
 * 
 * @returns void
 */
function requestAndSetScore() {
    var uuid = getCookieUUID();
    var score;

    $.ajax({
        url: contextPath +'/score/' + uuid,
        type: 'GET',
        success: function (res) {
            score = $.parseJSON(res);
            document.getElementById('score').textContent = score;
        },
        error: function () {
            score = null;
            console.log("Error loading Score!");
        }
    });

}

/**
 * Check if Cookies are enabled.
 * 
 * @returns {Boolean}
 */
function cookiesEnabled() {
    var cookieEnabled = (navigator.cookieEnabled) ? true : false;

    if (typeof navigator.cookieEnabled == "undefined" && !cookieEnabled) {
        document.cookie = "testcookie";
        cookieEnabled = (document.cookie.indexOf("testcookie") != -1) ? true : false;
    }
    return (cookieEnabled);
}
