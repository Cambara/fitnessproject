angular.module('MapsModel', ['Ajax']);
angular.module('MapsModel').factory('Maps', function(Request){

	
	var maps = {
			markes:[],
			options:{center:null,zoom:15},
			display:null,
			lat:0,
			lng:0,
			url_place : ''
			
	};
	var map;
	var infowindow;
	var image = {
		url: 'http://localhost:8080/fitnessproject/img/icon/gym2_icon.png',
	    size: new google.maps.Size(32, 32),
	    origin: new google.maps.Point(0,0),
	    anchor: new google.maps.Point(0, 48)
	  };
	function initialize() {
	  
	  var pyrmont = new google.maps.LatLng(maps.lat,maps.lng);
	  maps.options.center = pyrmont;
	  map = new google.maps.Map(maps.display, maps.options);
	  infowindow = new google.maps.InfoWindow({maxWidth: 500 ,maxHeight: 700});
	  var service = new google.maps.places.PlacesService(map);
	  Request.url = maps.url_place;
	  Request.post().then(function(data) {
		  maps.marks = data;
		  callback();			
		},function(data) {
			alert('Ops tivemos um problema!');
	  });
	}
	
	function callback() {
		for(var i in maps.marks){
			createMarker(maps.marks[i]);
		}
	 
	}
	
	function createMarker(place) {
	  var placeLoc = new google.maps.LatLng(place.location.lat,place.location.lng);
	  var marker = new google.maps.Marker({
	    map: map,
	    icon: image,
	    position: placeLoc
	  });
	  google.maps.event.addListener(marker, 'click', function() {
		var content = " <div id='content' class='infowindow-content'>" +
							"<div class=''>"+						
								"<h4>"+place.name+"</h4>"+
							"</div>"+
							"<hr>"+
							"<div>"+
								"<div class='info-box-maps'>" +
									"<span class='info-title-box-maps'>Email:</span><span>"+place.email+"</span>"+
								"</div>"+
								"<div class='info-box-maps'>" +
									"<span class='info-title-box-maps'>Telefone:</span><span>"+place.phone+"</span>"+
								"</div>"+ 
							"</div>"+
						"</div>";
		 
	    infowindow.setContent(content);
	    infowindow.open(map, this);
	  });
	}
	function initializeDisplay() {
		if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(function(position) {
				maps.lat = position.coords.latitude;
				maps.lng = position.coords.longitude;
				initialize();
			},function() {
				errorGeolocation(true);
		    });
		}else{
			errorGeolocation(false);
		}
	}
	function errorGeolocation(errorFlag) {
		if(errorFlag){
			alert('Ops parece que tivemos problema para pegar sua localização!');
		}else{
			alert('Ops parece que seu navegador não suporta geolocalização!');
		}
		maps.lat = -33.890542;
		maps.lng = 151.274856;
		initialize();
	}
	maps.load = function() {		
		google.maps.event.addDomListener(window, 'load', initializeDisplay);	
	}	 
	return maps;
});