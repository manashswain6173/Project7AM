/**
 * This Javascript file will validate the form page 
 */
$(function() {
  $("#datepicker").datepicker({
	  changeMonth: true,
		changeYear: true,
		showOtherMonths: true,
		 maxDate: new Date()
		  });
});

$(function(){
	var regform=$("#submit_form")
	$.validator.addMethod("noSpace",function(value,element){
		return value=='' || value.trim().length !=0
	},"Spaces are Not allowed");
	
	$.validator.addMethod("mobValidate",function(value,element){
		return value.length !=11
	},"Please enter validate mobile number")
	
	if(regform.length){
		regform.validate({
			rules:{
				firstName:{
					required:true,
					noSpace:true
				},
				lastName:{
					required:true,
					noSpace:true
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
					mobValidate:true
				},
				state:{
					required:true,
					noSpace:true
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
