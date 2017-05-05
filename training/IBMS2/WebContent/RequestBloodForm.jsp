<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Form</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<script type="text/javascript" src="js/jquery.validate.min.js"></script>

 <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  
<!--   <link href="runnable.css" rel="stylesheet" /> -->
  <!-- Load jQuery and the validate plugin -->
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  
  <!-- jQuery Form Validation code -->
 <script src="js/RequestForm.js"> </script>
 <style type="text/css">
  	.my-error-class {
    	color:#FF0000;  /* red */
    	display: inline;
	}
  </style>
</head>
<body>
<form id="request-form" name="request" action="FrontController2" method="post" >
	<div>
    	Patient's Name:   <input id="patientName" name="patientname" type="text">
	</div>
	<div>
		Doctor's Name:  <input id="doctorName" name="doctorname" type="text">
	</div>
	<div>
	    Required Blood Group: <select name="rbg">
                                  <option value="default">-Choose-</option>
                                  <option value="O_POSITIVE">O+</option>
                                  <option value="O_NEGATIVE">O-</option>
                                  <option value="A_POSITIVE">A+</option>
                                   <option value="A_NEGATIVE">A-</option>
                                   <option value="B_POSITIVE">B+</option>
                                   <option value="B_NEGATIVE">B-</option>
                                   <option value="AB_POSITIVE">AB+</option>
                                   <option value="AB_NEGATIVE">AB-</option>
                                  </select>
	</div>
	<div>
		Time of requirement:<input name="requiredTime" type="date">
	</div>           
	<div>
		Units:<input id="units" type="number" name="units" >
	</div>
    <div>
		Type of blood: <select name="bloodtype" >
                        <option value="default">-Choose-</option>
                         <option value="PRC">PRC</option>
                         <option value="PC">PC</option>
                         <option value="FFP">FFP</option>
                         <option value="WB">Whole Blood</option>
                       </select>
	</div>      
  	 <input type="submit" value="Submit">
</form>
<%
    List<String> errorMessages=(List<String>)session.getAttribute("errorMessages");
    if(errorMessages!=null)
    {
    for(String s:errorMessages)
    {
    	out.println("<BR>");
    	out.println(s); 
    }
    }
    
 %>
</body> 
</html>