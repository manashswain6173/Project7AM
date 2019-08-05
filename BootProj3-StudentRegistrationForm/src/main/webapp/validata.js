/**
 * This Javascript file will validate the form page 
 */

$(function(){
	var regform=$("#submit_form")
	$.validator.addMethod("noSpace",function(value,element){
		return value=='' || value.trim().length !=0
	},"Spaces are Not allowed and field size must be 20 char");
	
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
				gender:{
					required:true
				},
				address:{
					required:true,
					noSpace:true
				},
				email:{
					required:true,
					email:true,
					noSpace:true
				},
				mobileNo:{
					required:true,
					noSpace:true,
					mobValidate:true
				},
			},
			messages:{
				firstName:{
					required:'First name is required'
				},
				lastName:{
					required:'Last name is required'
				},
				gender:{
					required:'gender is required'
				},
				address:{
					required:'Address is required'
				},
				email:{
					required:'Email is required',
					emial:'Enter a validate email'
				},
				mobileNo:{
					required:'MobieleNO is required'
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
