


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



function putServerData(url, data, success){
    $.ajax({
		type : 'PUT',
		contentType : "application/json; charset=utf-8", 
        dataType : "json",
		data : data,
        url: url
    }).done(success);
}


function deleteServerData(url){

    $.ajax({
		type: 'DELETE',	
        url: url, 
		contentType : 'application/json',
        dataType: "json",
        success: function () {
                    alert('Do you really want to cancel this aircraft ?');
                },
    });
}


function fillTable(container){
	var template = _.template($('#templateRow').html());
	var result = "";
	
	container.forEach(aircraft => result += template(aircraft));
	
		$("#result").append(result);
}


	$(function(){
		
		$("#buttonAdd").click(function(){
			
			var data = 
				{
				model : $("#model").val(),
				owner : $("#owner").val(),
				numberOfPlaces : $("#numberOfPlaces").val()
				};
				
			putServerData("ws/AircraftResource/add-aircraft",JSON.stringify(data), function(result){
			alert("Success " + result);
		});
		});
		
		$("#buttonGet").click(function(){
			var aircraftId = $("#inputGet").val();
			
			getServerData("ws/AircraftResource/aircraft-info/"+ aircraftId);
		});
		
		
		$("#buttonDelete").click(function(){
			var id = $("#inputDelete").val();
			deleteServerData("ws/AircraftResource/delete-aircraft/"+ id,fillTable);
	});
});






