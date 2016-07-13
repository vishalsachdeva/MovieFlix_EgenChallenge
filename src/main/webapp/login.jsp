<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="UTF-8">
    <title>MovieFlix</title>
<script src="http://www.google.com/jsapi" type="text/javascript"></script>
<script type="text/javascript">
    google.load("jquery", "1.2.6");
</script>
<script type="text/javascript" src="js/login.js"></script>
<link rel="stylesheet" href="css/login.css">
    
  </head>
  <body class = "bg-body">
        <p style="text-align:center">
  
  </p>
    <body>
    <script type = "javascript" src="js/login.js"></script>
	<div class="login">

		<div class="login-screen">
			<div class="app-title">
				<h1>Login</h1>
			</div>

			<div class="login-form">
 		<form id="loginForm"> 
 				

				<div class="control-group">
				<input type="email" class="login-field" name = "email" value="" placeholder="username" id="email">
				<label class="login-field-icon fui-user" for="email"></label>
				</div>

				<div class="control-group">
				<input type="password" class="login-field" name = "password" value="" placeholder="password" id="password">
				<label class="login-field-icon fui-lock" for="password"></label>
				</div>

								<button id="LoginId" type="submit" name="undefined" >Login</button>
								<p></p>
								
								<label id="message" class="msg"><p>This User is not registered </p>
								<p>Sign Up?   <a class="signup-link" href="index.jsp">Register</a></p>
								</label>								
								
																
								<div class ="sep" >
								
								<p></p>
								</div>
								
								
								
								<a class="login-link" href="index.jsp">Forgot your password?</a>
				</form>
								
			</div>
		</div>
	</div>
	
</body>
  
  </body>
</html>