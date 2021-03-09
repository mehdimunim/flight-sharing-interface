function getServerData(url, success){
	
	var data = {
   	 	id: 40 
	};
    $.ajax({
  		method: "POST",
  		dataType: "json",
  		data: JSON.stringify(data)
	})
  		.done(function( msg ) {
    	alert( "Data Saved: " + Modification_made );
  	});


function callDone(resultDivi){
	var templateModifyFlight = _.template($('#templateModifyFlight').html());

	var html = templateModifyFlight({
		"attribute":JSON.stringify(resultDivi)
	});

	$("#resultDivi").append(html);
}

$(function(){
	$("#btnModifyFlights").click(function(){
		getServerData("ws/flightResource/flight",callDone);
	});
});

}