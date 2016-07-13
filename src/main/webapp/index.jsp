<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MovieFlix</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

<script src="http:////code.jquery.com/jquery-1.10.2.js"></script>

<script src="js/index.js"></script>


</head>
<body>
       
<div class = "container">
<form action="/movieFlix/api/users/signup" method="post" id="submitForm">     

	     <div class="header">
        
            <h3>Sign Up</h3>
            

            
        </div>
        <div class ="sep" ></div>
        <div class="inputs">

	                <label for=name>First Name</label>
	                <input type="text" name = "firstName" placeholder = "First Name" />

                    <label for=name>Last Name</label>
                	<input type="text" name = "lastName" placeholder = "Last Name"/>

	                <label for=email>Email</label>
	                <input type="email" name = "email" placeholder = "e-mail"/> 

	                <label for=password>Password</label>
	                <input type="password" name = "password" placeholder = "password" />
     				
     					
	             

	          <input type="hidden" value="user" name="role" />
	    </div>
	    
		<input id="submitId" type="submit" value="Sign Up">
		<p></p>
		
		 <div class ="sep" ></div>
		 
		 <div>
		 
		 	<p><h3> Have Existing Account ?</h3><input id="submitId" type="submit" href="login.jsp"  value="Login">
		 	
		 	
		 </div>
		 
	</form> 

</div>		
        
</body>
</html>