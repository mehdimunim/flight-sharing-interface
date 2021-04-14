
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
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


function deleteServerData(url, success){

    $.ajax({
		type: 'DELETE',	
		contentType : "application/json; charset=utf-8", 
        dataType : "json",
        url: url
    }).done(success);
}



function fillTable(container){
	var template = _.template($('#templateRow').html());
	var result = "";
	
	container.flights.forEach(flight => result += template(flight));
	
		$("#result").append(result);
}

function callDone(result){
	var templateExample = _.template($('#templateExample').html());
	
	var html = templateExample({
		//"attribute":JSON.stringify(result[0].flightID)
		"attribute":JSON.stringify(result)
	});
	//https://makitweb.com/return-json-response-ajax-using-jquery-php/
	$("#result").append(html);
}


$(function(){
	$("#buttonAdd").click(function(){
		var data = $("#inputAdd").val();
		
		putServerData("ws/FlightResource/add-flight",data, function(result){
			alert("Success " + result);
		});
	});
	
	$("#buttonGet").click(function(){
		var id = $("#inputGet").val();
		
		getServerData("ws/FlightResource/flight-info/"+ id, fillTable);
	});
	
	$("#buttonDelete").click(function(){
			var id = $("#inputDelete").val();
		deleteServerData("ws/FlightResource/delete-flight/",callDone);
			
		});
});













