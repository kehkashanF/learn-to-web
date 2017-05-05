
function displayHandle(tab,div) {
		
// 		alert('till here');
// 		alert("'"+tab+"'");
		
		document.getElementById("listBanksTab").setAttribute("class", "passive");
		
		document.getElementById("editDetailsTab").setAttribute("class", "passive");
		document.getElementById("requestBloodTab").setAttribute("class", "passive");
		document.getElementById("cancelRequestTab")
				.setAttribute("class", "passive");
		document.getElementById("viewRequestTab").setAttribute("class", "passive");
		document.getElementById("allTab").setAttribute("class", "passive");
		
		document.getElementById("fulfilledTab").setAttribute("class", "passive");
		document.getElementById("inprogressTab").setAttribute("class", "passive");
		document.getElementById("cancelledTab").setAttribute("class", "passive");
		document.getElementById("editDetailsTab").setAttribute("class", "passive");
		
		document.getElementById("listAllRequests").style.display = "none";
		document.getElementById("listAllBB").style.display = "none";
		document.getElementById("cancelRequest").style.display = "none";
		document.getElementById("requestForm").style.display = "none";
		document.getElementById("allRequests").style.display = "none";
		document.getElementById("fulfilledRequests").style.display = "none";
		document.getElementById("progressRequests").style.display = "none";
		document.getElementById("cancelledRequests").style.display = "none";
		document.getElementById("editDetails").style.display = "none";
		
		
		if(tab.localeCompare("fulfilledTab") == 0 || tab.localeCompare("inprogressTab") == 0 || tab.localeCompare("cancelledTab") == 0 || tab.localeCompare("allTab") == 0){
			document.getElementById("listAllRequests").style.display = "block";
			document.getElementById("viewRequestTab").setAttribute("class", "active");
		}
		document.getElementById(tab).setAttribute("class", "active");
		document.getElementById(div).style.display = "block";
		
		if(tab.localeCompare("viewRequestTab") == 0){
			document.getElementById("allRequests").style.display = "block";
			document.getElementById("allTab").setAttribute("class", "active");
			//alert('b6');
					
		}
		
		
		

	}
	
	function changeOfficer() {
		
		document.getElementById("ChangeOfficer").style.display = "block";
		document.getElementById("change_off").style.visibility = "hidden";
	}
	
	function changeContact() {
		
		document.getElementById("ChangeContact").style.display = "block";
		document.getElementById("change_con").style.visibility = "hidden";
	}
	