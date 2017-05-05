package com.psl.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.psl.bean.Donor;
import com.psl.bean.StockItem;
import com.psl.dao.BloodBankDAO;

@Path("/")
public class BloodBankService {

	@POST
	@Path("/checkAvailability")
	public String checkAvailability(@FormParam("bloodGroup") String bloodGroup,
			@FormParam("bloodType") String bloodType,
			@FormParam("quantity") int quantity) {

		return (new BloodBankDAO().checkIfAvailable(bloodGroup, bloodType,
				quantity));
	}

	@POST
	@Path("/getUnitsAvailable")
	public String getUnitsAvailable(@FormParam("bloodGroup") String bloodGroup,
			@FormParam("bloodType") String bloodType
			) {

		return (new BloodBankDAO().getUnitsAvailable(bloodGroup, bloodType));
	}
	
	
	
	@POST
	@Path("/contactDonor")
	public void contactDonors(@FormParam("requestId") int requestId,
			@FormParam("bloodGroup") String bloodGroup,
			@FormParam("date") Date date,
			@FormParam("bloodBankId") int bloodbankId) {
		new BloodBankDAO().contactDonor(bloodGroup, date, requestId,
				bloodbankId);
	}

	@POST
	@Path("/updateStock")
	public void updateStock(@FormParam("bloodGroup") String bloodGroup,
			@FormParam("bloodType") String bloodType,
			@FormParam("quantity") int quantity) {
		new BloodBankDAO().updateStock(bloodGroup, bloodType, quantity);
	}

	@GET
	@Path("/getAllDonors")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<Donor> getAllDonors() {
		List<Donor> listOfDonors = new BloodBankDAO().getAllDonors();
		return listOfDonors;
	}
	@GET
	@Path("/getStock")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<StockItem> getStockAvailable() {
		List<StockItem> listOfStock = new BloodBankDAO().getStockAvailable();
		return listOfStock;
	}
	
	@GET
	@Path("/tp")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<String> tp(){
		List<String> abc = new ArrayList<String>();
		abc.add("hii");
		abc.add("bye");
		return abc;
	}
	
	@POST
	@Path("/getQuantity")
	public String getQuantity(@FormParam("bloodGroup") String bloodGroup,
			@FormParam("bloodType") String bloodType){
		return new BloodBankDAO().getQuantity(bloodGroup, bloodType);
		
	}
}
