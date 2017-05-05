
$(function() {
  
    // Setup form validation on the #register-form element
    $("#edit-form").validate({
    	errorClass: "my-error-class",
        validClass: "my-valid-class",
        // Specify the validation rules
		        rules: {
                     
            change3: {
                required: true,
                minLength: 5
            },
           
            newOfficer: "required",
            newNumber: {
            	required: true,
            	tel: true,
            	minLength: 10,
            	maxLength: 10,
            	digits: true
            	
            },
            
            
        },
        
        // Specify the validation error messages
        messages: {
           
            change3: {
                required: "Password cannot be blank",
                minLength: "Your password must be at least 5 characters long"
            },
            
            newOfficer: "Officer's Name cannot be blank",
            newNumber:{
            	required: "Contact no. cannot be blank",
            	tel: "Please enter valid contact number",
            	minLength: "Mobile no. must be of 10 digits",
            		maxLength: "Mobile no. must be of 10 digits",
            			digits : "should be only digits"
            },
           
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  
 
  
	