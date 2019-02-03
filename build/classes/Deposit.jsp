<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Balance</title>
</head>
<body bgcolor="#D8BFD8">
<h3>Your Current Balance after Deposit is 
<%
	String newBal = (String)request.getAttribute("newBal");
    out.println(newBal);
%>
<h4>Your Deposit amount is 
<%
	String addBal = (String)request.getAttribute("addBal");
    out.println(addBal);
%>
</h4>
</h3></body>
	<br><input type=button value="Back" onCLick="history.back()">
</html>