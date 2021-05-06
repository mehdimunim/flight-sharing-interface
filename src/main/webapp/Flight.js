


function getServerData(url){
    $.ajax({
        dataType: "json",
        url: url,
		success: function(data) {
				var row = $('<tr><td>' + data.aircraftId + '</td><td>' + data.pilotId + '</td></tr>');
				$('#myTable').append(row);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Error: ' + textStatus + ' - ' + errorThrown);
		}
	});
}






function getPlaces(url){
    $.ajax({
        dataType: "json",
        url: url,
		success: function(data) {
				var row = $('<tr><td>' + data + '</td><td>');
				$('#myTable2').append(row);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Error: ' + textStatus + ' - ' + errorThrown);
		}
	});
}



	$(function(){
		
		$("#buttonGet").click(function(){
			var flightId = $("#inputGet").val();
			
			getServerData("ws/FlightResource/flight-info/"+ flightId);
		});
		
		$("#buttonGetPlaces").click(function(){
			var id = $("#inputGetPlaces").val();
			
			getPlaces("ws/FlightResource/availablePlaces/"+ id);
		});
		
	
});





