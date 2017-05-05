$(document).ready(function(){
	$("#login").click(function(){
	var email = $("#email").val();
	var password = $("#password").val();
	// Checking for blank fields.
	if( email =='' || password ==''){
		$('input[type="text"],input[type="password"]').css("border","2px solid red");
		$('input[type="text"],input[type="password"]').css("box-shadow","0 0 3px red");
		alert("Please fill all fields");
	}else {
		$.post("LoginServlet",{ email1: email, password1:password},
			function(data) {
			alert(typeof data);
			alert(data);
				if(data == "false"){
					$('input[type="text"],input[type="password"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
					$( "#first-tab" ).append('<div><label for="name" style="color:red">Invalid username or password!</label></div>');
					alert("Invalid username or password!");
				} else if(data=="true"){
					$("form")[0].reset();
					$('input[type="text"],input[type="password"]').css({"border":"2px solid #00F5FF","box-shadow":"0 0 5px #00F5FF"});
					alert("Success");
				} else{
					$('input[type="text"],input[type="password"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
					$( "#first-tab" ).append('<div><label for="name" style="color:red">Invalid username or password!</label></div>');
					alert("There seems to be a problem connecting to server");
				}
			});
		}
	});
});