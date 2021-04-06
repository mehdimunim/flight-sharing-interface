
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


function fillTable(container){
	var template = _.template($('#templateRow').html());
	var result = "";
	
	container.aircrafts.forEach(aircraft => result += template(aircraft));
	
		$("#result").append(result);
}


$(function(){
	$("#buttonAdd").click(function(){
		var data = $("#inputAdd").val();
		
		putServerData("ws/AircraftResource/aircraft",data, function(result){
			alert("Success " + result);
		});
	});
	
	$("#buttonGet").click(function(){
		var id = $("#inputGet").val();
		
		getServerData("ws/AircraftResource/aircraft/"+ id, fillTable);
	});
});






