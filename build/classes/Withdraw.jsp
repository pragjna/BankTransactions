<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>After Withdrawal</title>
</head>
<body bgcolor="#FFE4E1">
<h3>Your Current Balance after withdrawal is 
<%
	String newBal1 = (String)request.getAttribute("newBal1");
    out.println(newBal1);
%>
</h3></body>
<br><br><input type=button value="Back" onCLick="history.back()">
</html>