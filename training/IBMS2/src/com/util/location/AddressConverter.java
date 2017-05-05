package com.util.location;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;


public class AddressConverter {



 private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

 
 public static Proxy getProxy() {
	 Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("ngproxy.persistent.co.in", 8080));
	 return proxy;
 }
 
 public GoogleResponse convertToLatLong(String fullAddress) throws IOException {

 
  URL url = new URL(URL + "?address="
    + URLEncoder.encode(fullAddress, "UTF-8") + "&sensor=false");
  // Open the Connection
  
  URLConnection conn = url.openConnection(getProxy());
  System.out.println(url);

  InputStream in = conn.getInputStream();
  ObjectMapper mapper = new ObjectMapper();
  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
  in.close();
  return response;
  

 }
 
 public GoogleResponse convertFromLatLong(String latlongString) throws IOException {

 
  URL url = new URL(URL + "?latlng="
    + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
  // Open the Connection
  URLConnection conn = url.openConnection(getProxy());

  InputStream in = conn.getInputStream() ;
  ObjectMapper mapper = new ObjectMapper();
  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
  in.close();
  return response;
  

 }

 public static double getLatitude(String address){
	 GoogleResponse res;
	 double lati=0.0;
	try {
		res = new AddressConverter().convertToLatLong(address);
		 if(res.getStatus().equals("OK"))
		  {
			 for(Result result : res.getResults())
			   {
			    lati=Double.parseDouble(result.getGeometry().getLocation().getLat());
			    break;
			   }
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return lati;
 }
 
 public static double getLongitude(String address){
	 GoogleResponse res;
	 double longi=0.0;
	try {
		res = new AddressConverter().convertToLatLong(address);
		 if(res.getStatus().equals("OK"))
		  {
			 for(Result result : res.getResults())
			   {
			    longi=Double.parseDouble(result.getGeometry().getLocation().getLng());
			    break;
			   }
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return longi;
 }

  public double calculateDistance(String address1,String address2){
	  double lat1=getLatitude(address1);
	  double lon1=getLongitude(address1);
	  double lat2=getLatitude(address2);
	  double lon2=getLongitude(address2);
	  double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		
			dist = dist * 1.609344;
		

		return (dist);
  }
  
  private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}


	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
  
  
 }
 

