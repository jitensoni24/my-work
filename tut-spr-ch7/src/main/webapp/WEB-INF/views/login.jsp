<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Login Page for spring mvc demo">
	<meta name="author" content="SoniJit">

	<title>Login Yahoo!!!</title>
	
	</head>
<body>
	<p><font color="red">${ errorMessage }</font>
	
	<form action="/spring-mvc/login" method="POST">
		<label>Username</label>
			<input type="text" name="username">
		<label>Password</label>
			<input type="password" name="password">
		
		<input type="submit" name="Login">
	</form>
</body>
</html>