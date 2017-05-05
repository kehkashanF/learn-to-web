					
function displayHandle(tab,div) {
		document.getElementById("stockTab").setAttribute("class", "passive");
		document.getElementById("editDetailsTab").setAttribute("class", "passive");
		document.getElementById("listDonorsTab").setAttribute("class", "passive");
		document.getElementById("myReqTab").setAttribute("class", "passive");
		
		document.getElementById("listDonors").style.display = "none";
		document.getElementById("editDetails1").style.display = "none";
		document.getElementById("stock").style.display = "none";
		document.getElementById("myReq").style.display = "none";

		//		
//		
//		if(tab.localeCompare("fulfilledTab") == 0 || tab.localeCompare("inprogressTab") == 0 || tab.localeCompare("cancelledTab") == 0 || tab.localeCompare("allTab") == 0){
//			document.getElementById("listAllRequests").style.display = "block";
//			document.getElementById("viewRequestTab").setAttribute("class", "active");
//		}
		document.getElementById(tab).setAttribute("class", "active");
		document.getElementById(div).style.display = "block";
		
//		if(tab.localeCompare("viewRequestTab") == 0){
//			document.getElementById("allRequests").style.display = "block";
//			document.getElementById("allTab").setAttribute("class", "active");
//			//alert('b6');
//					
//		}
//		
		
		

	}

function changeBTO() {
	
	document.getElementById("ChangeBTO").style.display = "block";
	document.getElementById("change_bto").style.visibility = "hidden";
}
	function changeOfficer() {
		
		document.getElementById("ChangeOfficer").style.display = "block";
		document.getElementById("change_off").style.visibility = "hidden";
	}
	
	function changeContact() {
		
		document.getElementById("ChangeContact").style.display = "block";
		document.getElementById("change_con").style.visibility = "hidden";
	}
	