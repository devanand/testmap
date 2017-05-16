var map, marker;
       
function initiate_geolocation() {
	  if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var lat = position.coords.latitude;
				var long1 = position.coords.longitude;
				map = new google.maps.Map(document.getElementById('map'), {
					zoom: 12,
					center: new google.maps.LatLng(lat, long1),
					styles: [
					         {
					        	 featureType: 'all',
					        	 stylers: [
					        	           { saturation: -80 }
					        	           ]
					         },{
					        	 featureType: 'road.arterial',
					        	 elementType: 'geometry',
					        	 stylers: [
					        	           { hue: '#00ffee' },
					        	           { saturation: 80 }
					        	           ]
					         },{
					        	 featureType: 'poi.business',
					        	 elementType: 'labels',
					        	 stylers: [
					        	           { visibility: 'off' }
					        	           ]
					         }
					         ]
				});
				marker = new google.maps.Marker({
			        position: new google.maps.LatLng(lat, long1),
			        map: map
			    });
		});
	}
}
