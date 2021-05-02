
function updateRegistration(url, data, success){
                 $.ajax({
                     url: url,
                     type: 'PUT',
                     dataType: 'json',
					 contentType : 'application/json',
                     data: data
                 }).done(success);
}

function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}


$(function(){
//	$("#button").click(function(){
		
	$("#registration-form").submit(function (event) {
	
		var user = {
    		"firstname" : $('#firstname').val(),
    		"lastname" : $('#lastname').val(),
    		"email" : $('#email').val(),
        "confirmemail" : $('#confirmemail').val(),
			"password" : $('#password').val(),
			"repeatpassword" : $('#repeatpassword').val()
		};
		//var dataJson = JSON.stringify(user);

		updateRegistration("ws/flight-sharing/PassengerResource/register",user, callDone);
		
		event.preventDefault();
	});
});
