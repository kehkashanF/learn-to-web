var today=new Date();
$(function() {
	
	$.validator.addMethod("dateHigherThanToday", function(value, element) {
	
	  //If false, the validation fails and the message below is displayed
	
	  var myDate = value;
	
	  return Date.parse(myDate) > new Date();
	
	  }, "Date must be higher than current date");
	
	
	$.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg != value;
		 }, "Value must not equal arg.");

    // Setup form validation on the #register-form element
    $("#request-form").validate({
    	errorClass: "my-error-class",
        validClass: "my-valid-class",
        // Specify the validation rules
        rules: {
        	patientname: "required",     
            doctorname: "required",    
            rbg: {
            	required: true,
            	valueNotEquals: "default"
            },
            requiredTime: "required date dateHigherThanToday",
            units:{
            	required: true,
            	number: true
            },
            bloodtype: {
            	required: true,
            	valueNotEquals: "default"
            }, 

        },
        
        // Specify the validation error messages
        messages: {
        	patientname: "Hospital Name cannot be blank",
            doctorname: "Doctor's Name cannot be blank",
            rbg:{
            	valueNotEquals: "Please choose blood group"
            },
            requiredTime: {
            	required: "Please enter date",
            	dateHigherThanToday: "Date must be after today's date"
            },
            units: {
            	required: "Please enter number of units required",
            	number: "Please enter a valid number"
            },
            
            bloodtype: {
            	valueNotEquals: "Please choose blood group"
            },
        },
      
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  
 
  
	