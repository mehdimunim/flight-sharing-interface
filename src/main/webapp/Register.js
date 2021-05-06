
function putServerData(url, data, success){
    $.ajax({
		type : 'PUT',
		contentType : "application/json; charset=utf-8", 
        dataType : "json",
		data : data,
        url: url
    }).done(success);
}



function callDone(r){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(r)
	});

	$("#r").append(html);
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
		

	});
