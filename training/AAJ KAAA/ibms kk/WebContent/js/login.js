$(document).ready(function(){
	$("#login").click(function(){
	var email = $("#email").val();
	var password = $("#password").val();
	// Checking for blank fields.
	if( email == '' || password == ''){
		$('input[type="text"],input[type="password"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
					$( "#first-tab" ).append('<div><label for="name" style="color:red">Please fill all fields</label></div>');
					alert("Please fill all fields!");
					alert(email+password);
	}else {
		$.post("LoginServlet",{ email1: email, password1:password},
			function(data) {
				//data = JSON.parse(data);
//			alert(data);
				if(data.response=='false'){
					$('input[type="text"],input[type="password"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
					$( "#first-tab" ).append('<div><label for="name" style="color:red">Invalid username or password!</label></div>');
					alert("Invalid username or password!");
				} 
//				else if(data=="H"||data=="B"){
//					$("form")[0].reset();
//					$('input[type="text"],input[type="password"]').css({"border":"2px solid #00F5FF","box-shadow":"0 0 5px #00F5FF"});
//					
//					//window.location("LoginServlet");
//				} 
//				else{
//					$('input[type="text"],input[type="password"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
//					$( "#first-tab" ).append('<div><label for="name" style="color:red">Cannot connect to server currently!</label></div>');
//					alert("There seems to be a problem connecting to server");
//				}
				else { //data == 'true'
					if(data.next == "hospital")
						window.location="HospitalHome.jsp";
					else{
						
						window.location="bloodBankHome.jsp";
					}
				}
			});
		}
	});
});