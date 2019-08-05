/**
 * This Javascript file will validate the form page 
 */
$(function() {
  $("#datepicker").datepicker({
	  changeMonth: true,
		changeYear: true,
		showOtherMonths: true,
		showButtonPanel:true,
		 //yearRange: "1950:2019",
		yearRange: "-50:+10",
		 dateFormat: 'dd MM yy',
		 maxDate: new Date()
		  });
});

$(function(){
	var regform=$("#submit_form")
	$.validator.addMethod("noSpace",function(value,element){
		return value=='' || value.trim().length !=0
	},"Spaces are Not allowed");
	
	$.validator.addMethod("mobValidate",function(value,element){
		return value.length !=11 || /^[0-9-+]+$/i.test(value);
	},"Please enter validate mobile number");
	
	
  $.validator.addMethod("lettersonly", function(value, element) {
     return this.optional(element) || /^[a-z\s]+$/i.test(value);
  },"please enter characters only");
  
  
  $.validator.addMethod("phoneUS", function (value, element) {
	  //value = value.replace(/\s+/g, "");
      return this.optional(element) || // value.length > 9 &&
      value.match(/^[0-9-+]+$/);
  }, "Please specify a valid phone number");
	
	if(regform.length){
		regform.validate({
			rules:{
				firstName:{
					required:true,
					noSpace:true,
					lettersonly:true
				},
				lastName:{
					required:true,
					noSpace:true,
					lettersonly:true
				},
				dob:{
					required:true
				},
				gender:{
					required:true
				},
				phoneNo:{
					required:true,
					noSpace:true,
					mobValidate:true,
					phoneUS:true
				},
				state:{
					required:true
				},
				phote:{
					required:true
				}
			},
			messages:{
				firstName:{
					required:'First name is required'
				},
				lastName:{
					required:'Last name is required'
				},
				dob:{
					required:'Date Of Birth is required'
				},
				gender:{
					required:'gender is required'
				},
				state:{
					required:'state is required'
				},
				phoneNo:{
					required:'MobileNO is required'
				},
				photo:{
					required:'Please upload your photo'
				},
				
			},
			errorPlacement:function(error,element){
				if(element.is(":radio")){
					error.appendTo(element.parents(".gender"));
				}
				else
					error.insertAfter(element);
			}
			
		});
		
	}
})
