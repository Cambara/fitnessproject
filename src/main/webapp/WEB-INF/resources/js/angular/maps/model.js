angular.module('MapsModel', []);
angular.module('MapsModel').factory('Maps', function(){

	
	var maps = {
			markes:[],
			options:{center:null,zoom:15},
			display:null,
			lat:0,
			lng:0
			
	};
	var map;
	var infowindow;
	var image = {
		url: 'http://localhost:8080/fitnessproject/img/icon/site_icon.png',
	    size: new google.maps.Size(48, 48),
	    origin: new google.maps.Point(0,0),
	    anchor: new google.maps.Point(0, 48)
	  };
	function initialize() {
	  
	  var pyrmont = new google.maps.LatLng(maps.lat,maps.lng);
	  maps.options.center = pyrmont;
	  map = new google.maps.Map(maps.display, maps.options);
	  infowindow = new google.maps.InfoWindow({maxWidth: 500 ,maxHeight: 700});
	  var service = new google.maps.places.PlacesService(map);
	  callback();
	}
	
	function callback() {
		//pegar no banco de dados a localização das academias
		var marks = [];	             
		marks.push({name:'my house',lat:-23.007025,lng:-45.5177757});
		marks.push({name:'some house',lat:-23.008125,lng:-45.5177857});
		marks.push({name:'some house',lat:-23.006155,lng:-45.5177897});
		
		for(var i in marks){
			createMarker(marks[i]);
		}
	 
	}
	
	function createMarker(place) {
	  var placeLoc = new google.maps.LatLng(place.lat,place.lng);
	  var marker = new google.maps.Marker({
	    map: map,
	    icon: image,
	    position: placeLoc
	  });
	
	  google.maps.event.addListener(marker, 'click', function() {
		var content = " <div id='content' class='infowindow-content container'>" +
						"<div class='row'>" +
						"<div class='col-xs-6'>"+						
							"<span>House</span> :"+place.name+
						"</div></div>"+
						"<div class='row'>" +
						"<div class='col-xs-6'>"+
						"<img src='http://localhost:8080/fitnessproject/img/icon/site_icon.png'/>"+
						"</div></div></div>";
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