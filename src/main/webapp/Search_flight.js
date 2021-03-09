function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function callDone(resultDiv){
	var templateFlight = _.template($('#templateFlight').html());

	var html = templateFlight({
		"attribute":JSON.stringify(resultDiv)
	});

	$("#resultDiv").append(html);
}

$(function(){
	$("#btnGetFlights").click(function(){
		getServerData("ws/flightResource/flight",callDone);
	});
});
