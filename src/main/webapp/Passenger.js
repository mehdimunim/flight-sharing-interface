


function getServerData(url){
    $.ajax({
        dataType: "json",
        url: url,
		success: function(data) {
				var row = $('<tr><td>' + data.firstName+ '</td><td>' + data.lastName + '</td><td>' + data.civilStatut + '</td></tr>'+ data.birthday + '</td></tr>' + data.email + '</td></tr>');
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
                    alert('Do you really want to remove this passenger from your scheduled flights ?');
                },
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



	$(function(){
		
			$("#buttonAdd").click(function(){
			
			var data = 
				{
				firstName : $("#firstName").val(),
				lastName : $("#lastName").val(),
				civilStatut : $("#civilStatut").val(),
				birthday : $("#birthday").val(),
				email : $("#email").val()
				};
				
			putServerData("ws/PassengerResource/add-passenger",JSON.stringify(data), function(result){
			alert("Success " + result);
		});
		});
		
		$("#buttonGet").click(function(){
			var passengerId = $("#inputGet").val();
			
			getServerData("ws/PassengerResource/passenger-info/"+ passengerId);
		});
		
		
		$("#buttonDelete").click(function(){
			var id = $("#inputDelete").val();
			
			deleteServerData("ws/PassengerResource/delete-passenger/"+ id);
	});
});
