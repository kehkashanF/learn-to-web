document.getElementById("name").onblur = createAjaxREquest;

function createAjaxREquest(){
	//1. Cerate XML Http Request Obj
	xmlHttpreq = new XMLHttpRequest();
	
	var data = document.getElementById("name").value;
	
	//2. create url
	var url = "requestProcessor.jsp";
	
	//3. Open the connection
	xmlHttpreq.open("POST", url, true);//ONLY initializes, does not open
	
	//4. on ready state change
	//registered whenever state of server changes
	xmlHttpreq.onreadystatechange=fetchResponse;
	
	xmlHttpreq.setRequestHeader("ContentType", "application/x-www-form-urlencoded");
	xmlHttpreq.send("param="+data);

}

function fetchResponse(){
	if(xmlHttpreq.readyState==4&&xmlHttpreq.status==200){
		
		var jsonStr = xmlHttpreq.responseText;
		
		
		document.getElementById("price").value=JSON.parse(jsonStr).price;
	}
	
}
