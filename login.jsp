<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="LoginRegister" method="post">
		<table>
			<tr>
				<td><h3>${message}</h3>
					<h3>${successMessage}</h3></td>
				<td></td>
			</tr>
			<tr>
				<td><b>Login Page</b></td>
				<td></td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Login"></td>
				<td><a href="Signup.jsp">Sign Up</a></td>
			</tr>
		</table>
	</form>
</body>
</html>