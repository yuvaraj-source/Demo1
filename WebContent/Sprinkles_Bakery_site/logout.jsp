<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG OUT</title>
</head>
<body>
	<%
	session.invalidate();
	response.sendRedirect(request.getContextPath());
	%>
</body>
</html>