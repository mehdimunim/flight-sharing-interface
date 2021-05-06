


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




function deleteServerData(url){

    $.ajax({
		type: 'DELETE',	
        url: url, 
		contentType : 'application/json',
        dataType: "json",
        success: function () {
                    alert('Do you really want to cancel this flight ?');
                },
    });
}




	$(function(){
		
		
		$("#buttonGet").click(function(){
			var aircraftId = $("#inputGet").val();
			
			getServerData("ws/AircraftResource/aircraft-info/"+ aircraftId);
		});
		
		
		$("#buttonDelete").click(function(){
			var id = $("#inputDelete").val();
			deleteServerData("ws/AircraftResource/delete-aircraft/"+ id);
	});
});
