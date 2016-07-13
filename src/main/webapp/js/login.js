

	$(document).ready(function() {
		

		$('#loginForm').submit(function(e) {
			var frm = $('#loginForm');
			e.preventDefault();
			var action = "api/users/login";
			var method = "get"
				
			

		    var data = {}
		    var Form = this;
		    
		    
		    
        $.ajax(
        		{
        	
                beforeSend: function (xhr){ 
                xhr.setRequestHeader("Content-Type","application/json");
                xhr.setRequestHeader("Accept","text/json");
            },
            ContentType : 'application/json' ,
            type: method,
            url: action,
            dataType : 'json',
            data : {email : $('#email').val(), password : $('#password').val() },//JSON.stringify(data),
            success : function(data){              
            	console.log(data.rsponseText);
            	window.location='main.jsp';
            },
            error : function(ts){
            	document.getElementById('message').style.display= "inline";
            	console.log(ts.responseText);
                $(this).html("Error!");
            }
        });
		});
	});