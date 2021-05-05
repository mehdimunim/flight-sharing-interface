
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


$(function(){
		
    $("#buttonAdd").click(function(){
        
        var data = 
            {
            aircraftId : $("#aircraftId").val(),
            pilotId : $("#pilotId").val(),
            departureDate : $("#departureDate").val(),
            departureTime : $("#departureTime").val(),
            arrivalDate : $("#arrivalDate").val(),
            arrivalTime : $("#arrivalTime").val(),
            departureAerodrome : $("#departureAerodrome").val(),
            arrivalAerodrome : $("#arrivalAerodrome").val(),
            price : $("#price").val(),
            meetingPlace : $("#meetingPlace").val()
            };
            
        putServerData("ws/FlightResource/add-flight",JSON.stringify(data), function(result){
        alert("Success " + result);
    });
    });
    

});

