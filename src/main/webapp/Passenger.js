

function getServerData(url, success){
    $.ajax({
        dataType: "json",
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
                    alert('Do you really want to remove this passenger from your scheduled flights ?');
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
		
		$("#buttonGet").click(function(){
			var passengerId = $("#inputGet").val();
			
			getServerData("ws/PassengerResource/passenger-info/"+ passengerId, fillTable);
		});
		
		
		$("#buttonDelete").click(function(){
			var id = $("#inputDelete").val();
			
			deleteServerData("ws/PassengerResource/delete-passenger/"+ id,fillTable);
	});
});
