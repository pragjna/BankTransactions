<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<h2>Login Successful for User 
<%
	String uid = (String)request.getAttribute("uid");
    out.println(uid);
%></h2>
<body bgcolor="#DCDCDC">

<form action="DepositServlet" method="get">
    <br><br>Deposit :<input type="text" name="deposit" placeholder="Enter Deposit Amount" > <br>
    	<input type="hidden" name="uid" value="<%=uid%>" />
		<input type="submit" value="Submit">
	</form>
<form action="WithdrawServlet" method="get"><right>
    <br><br>Withdraw :<input type="text" name="withdraw" placeholder="Enter Withdrawal Amount"> <br>
        <input type="hidden" name="uid" value="<%=uid%>" />
		<input type="submit" value="Submit">
	</form>
</body>
	<br><br><input type=button value="Back" onCLick="history.back()">
</html>
