<%@ page import="com.rojaware.member.bo.CustomerHandler"%>
<%@ page import="com.rojaware.member.model.Member"%>
<%@ page import="com.rojaware.member.test.DaoTester"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; euc-kr"
	pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*"%>

<html>
<head>
<style>
			textarea { border:1px solid #ccc; }
		</style>
		<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js'></script>
		<script src='jquery.autosize.js'></script>
		<script>
			$(function(){
				$('textarea').autosize();
			});
		</script>
		
<title>Cafe Member: Edit</title>
</head>
<body bgcolor="#ffffee">
	<h1>
		<center>Cafe Member Add New Member</center>
	</h1>
	<FORM METHOD=GET ACTION="index.jsp">
		Name: <INPUT TYPE=TEXT NAME=name SIZE=20>
        <INPUT TYPE=SUBMIT value="find" >
	</FORM>
	
	<FORM METHOD=GET ACTION="newMember.jsp">
       <INPUT TYPE=SUBMIT value="new" >
	</FORM>
		
	<form method=POST ACTION=CustomerController >		
		<INPUT TYPE=SUBMIT value="save" >
	<table align="center" cellpadding="1" cellspacing="1" border="1"
		width="80%" bgcolor="#dddddd">
		<tr>
			<th> Name  </th>
			<th><input type=text name=name ></th>
			<th>Sex</th>
			<th><input type="radio" name="sex" value="male" /> Male 
				<input type="radio" name="sex" value="female" checked /> Female</th>
			<th>Created</th>
			<th><input type=text name=created ></th>
		</tr>
		<tr>
			<th>Phone</th>
			<th><input type=text name=phone ></th>
			<th>email</th>
			<th><input type=text name=email ></th>
			<th>Naver</th>
			<th><input type=text name=naver ></th>
		</tr>
		<tr>
			<th> Grad School  </th>
			<th><input type=text name=gradSchool  ></th>
			<th>College</th>
			<th><input type=text name=college ></th>
			<th>Is Member</th>
			<th><input type="radio" name="isMember" value="Yes" /> Yes 
				<input type="radio" name="isMember" value="No" checked /> No
			</th>
		</tr>
		<tr>
			<th>Grad Major</th>
			<th><input type=text name=gradMajor ></th>
			<th>Major</th>
			<th><input type=text name=major ></th>
			<th>Expiry Date</th>
			<th><input type=text name=expiryDate  ></th>
		</tr>
		<tr>
			<th>Place</th>
			<th><input type=text name=place value="¼­¿ï"></th>
			<th>Skype</th>
			<th><input type=text name=visaType ></th>
			<th>Fee</th>
			<th><input type=text name=fee ></th>
		</tr>		
		<tr>
			<th>Counselor</th>
			<th><input type=text name=counselor ></th>
			<th></th>
			<th></th>
			<th>Birth Year</th>
            <th><input name=birthYear id="numbersOnly" pattern="[0-9.]+" type="text"> </th>
		</tr>
		<tr>
			<th>English Score</th>
				<th colspan=5><input type=text name=englishScore size=160></th>
		</tr>
		<tr>
			<th>Career</th>
				<th colspan=5><input type=text name=career size=160></th>
		</tr>
	</table>
	<br>
	
Profile:<BR>
<TEXTAREA NAME="content" COLS=150 ></TEXTAREA>
	
	<hr>
	<center>
		<p><INPUT TYPE=SUBMIT value="save" ></p>
	</center>
	</form>
</body>
</html>
