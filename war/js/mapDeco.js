var map;
       
function initiate_geolocation() {
	  if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var lat = position.coords.latitude;
				var long1 = position.coords.longitude;
				map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : lat,
					lng : long1
				},
				zoom : 20
			});
		});
	}
}
