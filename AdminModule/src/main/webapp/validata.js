/**
 * This Javascript file will validate the form page
 */
$(function() {
	$("#datepicker").datepicker({
		changeMonth : true,
		changeYear : true,
		showOtherMonths : true,
		showButtonPanel : true,
		// yearRange: "1950:2019",
		yearRange : "-50:+10",
		dateFormat : 'dd MM yy',
		maxDate : new Date()
	});
});

$(function() {

	$("#email").blur(function() {
		var enteredEmail = $("#email").val();
		$.ajax({
			url : "http://localhost:9094/checkEmail",
			data : "email=" + enteredEmail,
			success : function(result) {
				if (result == "available") {
					$("#emailMsg").html("Email already Registered!!");
					$("#email").focus();
					$("#submitbtn").prop("disabled", true);
				} else {
					$("#emailMsg").html("");
					$("#submitbtn").prop("disabled", false);
				}
			}
		});
	});

})

$(function() {
	var regform = $("#submit_form")
	$.validator.addMethod("noSpace", function(value, element) {
		return value == '' || value.trim().length != 0
	}, "Spaces are Not allowed");

	$.validator.addMethod("mobValidate", function(value, element) {
		return value.length != 11 || /^[0-9-+]+$/i.test(value);
	}, "Please enter validate mobile number");

	$.validator.addMethod("lettersonly", function(value, element) {
		return this.optional(element) || /^[a-z\s]+$/i.test(value);
	}, "please enter characters only");

	$.validator.addMethod("phoneUS", function(value, element) {
		// value = value.replace(/\s+/g, "");
		return this.optional(element) || // value.length > 9 &&
		value.match(/^[0-9-+]+$/);
	}, "Please specify a valid phone number");

	/*
	 * $.validator.addMethod("roleEmpty", function(value, element) { return
	 * value.length==0; }, "please Select Role");
	 */

	if (regform.length) {
		regform.validate({
			rules : {
				firstName : {
					required : true,
					noSpace : true,
					lettersonly : true
				},
				lastName : {
					required : true,
					noSpace : true,
					lettersonly : true
				},
				gender : {
					required : true
				},
				email : {
					required : true,
					email : true

				},
				password : {
					required : true,
					minlength : 5,
					maxlength : 15
				},
				dob : {
					required : true
				},
				ssn : {
					required : true
				},
				mobileNo : {
					required : true,
					noSpace : true,
					mobValidate : true,
					phoneUS : true
				},
				roles : {
					required : true
				}
			},
			messages : {
				firstName : {
					required : 'First name is required'
				},
				lastName : {
					required : 'Last name is required'
				},
				gender : {
					required : 'gender is required'
				},
				email : {
					required : 'Email is required'
				},
				password : {
					required : 'Password is required'
				},
				dob : {
					required : 'Date Of Birth is required'
				},
				ssn : {
					required : 'SSN_NO is Required'
				},
				mobileNo : {
					required : 'Mobile Number is required'
				},
				roles : {
					required : 'Select One Role'
				}
			},
			errorPlacement : function(error, element) {
				if (element.is(":radio")) {
					error.appendTo(element.parents(".gender"));
				} else
					error.insertAfter(element);
			}

		});

	}
})
