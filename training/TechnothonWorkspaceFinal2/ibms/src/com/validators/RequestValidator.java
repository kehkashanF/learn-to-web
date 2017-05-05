package com.validators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RequestValidator {
public List<String> validate(String patientname,String doctorname,String rbg,String requiredtime,Integer units,String bloodtype)
{
	System.out.println(requiredtime);
  List<String> errorMessages=new ArrayList<String>();
  if(patientname==null||patientname.equals(""))
  {
	  errorMessages.add("Patient name field cannot be empty");
  }
  if(doctorname==null||doctorname.equals(""))
  {
	  errorMessages.add("Doctor name field cannot be empty");
  }
  if(rbg==null||rbg.equalsIgnoreCase("default"))
  {
	  errorMessages.add("Kindly select a blood group from the list");
  }
 // if(requiredtime==null)
  //{
//	  errorMessages.add("Required time field cannot be empty");
  //} 
	 
  //Calendar requiredDate=Calendar.getInstance();
 // 
 // String[] dateTime = requiredtime.split("T");
 // String[] date = dateTime[0].split("-");
 // String[] time = dateTime[1].split(":");
//  requiredDate.set(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]),Integer.parseInt(time[0]),Integer.parseInt(time[1]));
//  Calendar current=Calendar.getInstance();
//  if(current.after(requiredDate))
//  {
//	  errorMessages.add("Required time should be later than the current time");
//  }
  
 // if(units==null||units<=0)
 // {
//	  errorMessages.add("Kindly select units of blood required");
 // }
  if(bloodtype==null||bloodtype.equalsIgnoreCase("default"))
  {
	  errorMessages.add("Kindly select a blood type from the list"); 
  }
  return errorMessages;
  }
}

