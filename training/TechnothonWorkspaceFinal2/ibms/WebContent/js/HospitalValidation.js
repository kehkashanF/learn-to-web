
$(function() {
  
    // Setup form validation on the #register-form element
    $("#register-form").validate({
    	errorClass: "my-error-class",
        validClass: "my-valid-class",
        // Specify the validation rules
        rules: {
            hName: "required",
            
            email: {
                required: true,
                email: true
            }, 
            
            
            password: {
                required: true,
                minlength: 5
            },
           
            oName: "required",
            circle: "required",
            contact: {
            	required: true,
            	tel: true,
            	minlength: 10,
            	maxlength: 10	
            },
            
            lNum: "required",
            cert: "required",
            address: "required",
            pincode: {
            	required: true,
            	minlength: 6,
            	digits: true
            }
        },
        
        // Specify the validation error messages
        messages: {
            hName: "Hospital Name cannot be blank",
            password: {
                required: "Password cannot be blank",
                minlength: "Your password must be at least 5 characters long"
            },
            email: {
            	required: "Email cannot be blank",
            	email: "Please enter valid email address"
            },
            oName: "Officer's Name cannot be blank",
            contact:{
            	required: "Contact no. cannot be blank",
            	tel: "Please enter valid contact number",
            	minlength: "Mobile no. must be of 10 digits",
            		maxlength: "Mobile no. must be of 10 digits",
            		digits: "Cannot have alphabets"
            		
            },
            lNum: "Enter valid license number",
            cert: "Certification is required",
            circle: "Circle is required",
            
            address: "Address cannot be blank",
            pincode: {
            	required: "Pincode cannot be blank",
            	minlength: "Enter valid pincode"	
            }
            
            
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  
 
  
	