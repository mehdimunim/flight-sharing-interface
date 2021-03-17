
function updateRegistration(url, success){
    var user = new Object();
    user.userName = $('#userName').val();
    user.userMobile = $('#userMobile').val();
    user.userEmail = $('#userEmail').val();
    user.userAddress = $('#userAddress').val();
    
                 $.ajax({
                     url: url,
                     type: 'POST',
                     dataType: 'json',
                     data: customer
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
	$("#button").click(function(){
		updateRegistration("/ws/flight-sharing/PassengerResource/register",callDone);
	});
});
