package com.psl.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.twilio.sdk.TwilioRestException;



public class Main {
@SuppressWarnings("deprecation")
public static void main(String[] args) {
//	 String message = "Urgent need for AB_POSITIVE blood on 12-12-2015. Between 4pm to 6pm. Click to confirm: "
//			 +new TinyURL().getUrl("http://localhost:8080/IBMS/BloodBankRegistration.html");
//	 
//	 try {
//		new SmsSender().sendMessage("+918657087611", message);
//	} catch (TwilioRestException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	java.sql.Date sqldate = Date.valueOf("2015-12-15");
	java.util.Date date = new java.util.Date(); //15-12-2015
	if(date.getDate() == sqldate.getDate()){
		System.out.println("urgent msg ");
	}
	else
		System.out.println("    aBC");
}
}
