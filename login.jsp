<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> treecutting </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"></link>
    <style>
        /* Add this style to check if it gets applied */
        h1 {
            color: blue;
        }
    </style>
</head>
<body>
	<div align="center">
		<h1> Welcome to BJJRanks </h1>
        <p>${pageContext.request.contextPath}</p>
		<form action="handleResetDatabase" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th> Email: </th>
					<td>
						<input type="text" name="email" size="45" autofocus>
					</td>
				</tr>
				<tr>
					<th> Password: </th>
					<td> 
						<input type="password" name="password" size="45">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Reset Database"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>