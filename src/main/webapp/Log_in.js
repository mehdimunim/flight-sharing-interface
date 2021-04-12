function authenticate(url, data) {

                    $.ajax
                    ({
                        type: 'PUT',
                        //the url where you want to sent the userName and password to
                        url: url,
						contentType : 'application/json',
                        dataType: 'json',
                      	data: data,

                        success: function (data) {
                            //do any process for successful authentication here
                            alert('Login status: ' + data.status);
                        }
                     })
                };
                

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
    		"email" : $("#email").val(),
    		"password" : $("#password").val()
		};
		//var dataJson = JSON.stringify(user);

		authenticate("ws/flight-sharing/PassengerResource/Login",user, callDone);
		
		event.preventDefault();
	});
});