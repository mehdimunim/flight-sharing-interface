
function getServerData(url){
    $.ajax({
        dataType: "json",
        url: url,
		success: function(data) {
				var row = $('<tr><td>' + data.model+ '</td><td>' + data.owner + '</td><td>' + data.numberOfPlaces + '</td></tr>');
				$('#myTable').append(row);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Error: ' + textStatus + ' - ' + errorThrown);
		}
	});
}




$(function(){
	$("#buttonGet").click(function(){
			var aircraftId = $("#inputGet").val();
			
			getServerData("ws/AircraftResource/aircraft-info/"+ aircraftId);
			});
			
		
});