

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
	
	container.forEach(aircraft => result += template(aircraft));
	
		$("#result").append(result);
}


	$(function(){
		
		$("#buttonAdd").click(function(){
			
			var data = 
				{
				passengerId : $("#passengerId").val(),
				flightId : $("#flightId").val(),
				timestamp : $("#timestamp").val()
				};
				
			putServerData("ws/BookingResource/add-booking",JSON.stringify(data), function(result){
			alert("Success " + result);
		});
		});
		
});


