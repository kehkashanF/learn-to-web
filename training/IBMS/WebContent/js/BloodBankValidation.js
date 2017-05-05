
$(function() {
  
    // Setup form validation on the #register-form element
    $("#register-form").validate({
    	errorClass: "my-error-class",
        validClass: "my-valid-class",
        // Specify the validation rules
        rules: {
            bName: "required",
            
            email: {
                required: true,
                email: true
            }, 
            
            
            password: {
                required: true,
                minlength: 5
            },
           
            btoName: "required",
            contact: {
            	required: true,
            	tel: true	
            },
            
            lNum: "required",
            circle: "required",
            address: "required",
            pincode: {
            	required: true,
            	minlength: 6,
            	number: true
            }
        },
        
        // Specify the validation error messages
        messages: {
            bName: "Blood Bank Name cannot be blank",
            password: {
                required: "Password cannot be blank",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Email cannot be blank",
            btoName: "Officer's Name cannot be blank",
            contact: "Enter valid contact number",
            lNum: "Enter valid license number",
            circle: "Please enter circle of which you are a part",
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
  
 
  
	