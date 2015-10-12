<%@ page import="com.rojaware.member.bo.CustomerHandler"%>
<%@ page import="com.rojaware.member.model.*"%>
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
	
	<FORM METHOD=POST ACTION="index.jsp">
		Name: <INPUT TYPE=TEXT NAME=name SIZE=20> <INPUT TYPE=SUBMIT
			value="find">
	</FORM>
	<FORM METHOD=GET ACTION="newMember.jsp">
		<INPUT type=SUBMIT value="new">
	</FORM>
	<FORM METHOD="POST" ACTION="CustomerController" >
		<INPUT type=SUBMIT value="save">
		<%
			request.setCharacterEncoding("euc-kr");
			String id = request.getParameter("memberId");
			CustomerHandler handler = new CustomerHandler();
			Member member = (Member) handler.findById(Integer.parseInt(id));
			int memberId = 0;
			String name = member.getName();
			String memberType = "";
			if (member != null) {
				 memberId = member.getMemberId();
				 if (member.isIsMember() )
					 memberType = "Á¤È¸¿ø";
		%>
		<h1>
		<center><%= memberType %> <%= name %></center>
	</h1>
		<table align="center" cellpadding="1" cellspacing="1" border="1"  width="300" bgcolor="#ddddff">
			<tr>
				<th width="100" >Name</th>
				<th><input type=text name=name value="<%=member.getName()%>"></th>
				<th>Sex</th>
				<%
				    String girlCheck="", boyCheck = "";
				
				    if( member.isGirl())
				    	girlCheck = "checked";
				    else
				    	boyCheck = "checked";
				%>
				<th><input type="radio" name="sex" value="male" <%= boyCheck %> /> Boy
					<input type="radio" name="sex" value="female" <%= girlCheck %> /> Girl
				<th>Created</th>
				<th><input type=text name=created
					value="<%=member.getCreated()%>"></th>
			</tr>
			<tr>
				<th>Phone</th>
				<th><input type=text name=phone value="<%=member.getPhone()%>"></th>
				<th>email</th>
				<th><input type=text name=email value="<%=member.getEmail()%>"></th>
				<th>Naver</th>
				<th><input type=text name=naver value="<%=member.getNaver()%>"></th>
			</tr><tr>
				<th>Grad School</th>
				<th><input type="text" name="gradSchool" value="<%=member.getGradSchool()%>"></th>
				<th>College</th>
				<th><input type="text" name="college" value="<%=member.getCollege()%>"></th>
				<th>Is Member</th>
				<%
				    String yesCheck="", noCheck = "";
				
				    if( member.isIsMember())
				    	yesCheck = "checked";
				    else
				    	noCheck = "checked";
				%>
				<th><input type="radio" name="isMember" value="Yes" <%= yesCheck %>> Yes 
				    <input type="radio" name="isMember" value="No" <%= noCheck %>> No
				</th>
			</tr>
			
			<tr>
				<th>Grad Major</th>
				<th><input type=text name=gradMajor
					value="<%=member.getGradMajor()%>"></th>
				<th>Major</th>
				<th><input type=text name=major value="<%=member.getMajor()%>"></th>
				<th>Expiry Date</th>
				<th><input type=text name=expiryDate
					value="<%=member.getExpiryDate()%>"></th>
			</tr>
			<tr>
				<th>Place</th>
				<th><input type=text name=place value="<%=member.getPlace()%>"></th>
				<th>Skype</th>
				<th><input type=text name=visaType
					value="<%=member.getVisaType()%>"></th>
				<th>Fee</th>
				<th><input type=text name=fee value="<%=member.getFee()%>"></th>
			</tr>
			<tr>
				<th>Counselor</th>
				<th><input type=text name=counselor
					value="<%=member.getCounselor()%>"></th>
				<th></th>
				<th></th>
				<th>Birth Year</th>
				<th><input type=text name=birthYear size=4
					value="<%=member.getBirthYear()%>"></th>
			</tr>
			<tr>
			<th>English
			</th>
			<th  colspan=5>
			<TEXTAREA NAME="englishScore" COLS=150 style="width: 1200px; height: 50px;"><%=member.getEnglishScore() %></TEXTAREA>
		    </th>
			</tr>
			<tr>
			<th>Career</th>
				<th colspan=5><TEXTAREA NAME="career" COLS=150 style="width: 1200px; height: 50px;"><%=member.getCareer() %></TEXTAREA>
		    </th>
			</tr>

			<input type="hidden" name=memberId value="<%= memberId %>">
			<%
				} else {
			%>
			No member is found by
			<%=id%>
			<%
				}
			%>
		</table>
		
		<P>
		<INPUT type=SUBMIT value="save">
		<hr>
		Profile:<BR>
		<TEXTAREA NAME="content"  style="width: 1200px; height: 150px;" ><%=member.getContent().trim() %></TEXTAREA>	
		<INPUT type=SUBMIT value="save">
	</FORM>
	<center><a href="editComment.jsp?memberId=<%= id %>">See Comments</a> </center>
		<br>
		
</body>
</html>
