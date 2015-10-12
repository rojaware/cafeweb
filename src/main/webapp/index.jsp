<%@ page import="com.rojaware.member.bo.CustomerHandler"%>
<%@ page import="com.rojaware.member.model.Member"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; euc-kr"
	pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*"%>

<html>
<head>
<title>Cafe Member: Home Page</title>
</head>
<body bgcolor="#ffffee">
	<h1>
		<center>Cafe Member Home Page</center>
	</h1>
	<FORM METHOD=POST ACTION="index.jsp">
		Name: <INPUT TYPE=TEXT NAME=name SIZE=20>
        <INPUT TYPE=SUBMIT value="Find" >
	</FORM>
	<FORM METHOD=POST ACTION="index.jsp?place=yes">
		Place: <INPUT TYPE=TEXT NAME=name SIZE=20>
	  <INPUT TYPE=SUBMIT value="Find" >
	</FORM>		
	<FORM METHOD=POST ACTION="newMember.jsp">
       <INPUT TYPE=SUBMIT value="New" > 
       <a href="index.jsp?expired=yes">Show Expired Members</a>
       <a href="sendMail.jsp">Mail to Expired Members</a>
	</FORM>

	<table align="center" cellpadding="2" cellspacing="2" border="1"
		width="80%" bgcolor="#dddddd">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Grad School</th>
			
			<th>English Score</th>
			<th>Place</th>
			<th>Is member</th>
			<th>Expiry Date</th>
			<th>ID</th>
			<th></th>
		</tr>
		<%
		    request.setCharacterEncoding("euc-kr");
		    String name = request.getParameter ("name") ;
		    CustomerHandler handler = new CustomerHandler();
			List<Member> memberList = null;
			boolean isExpired = false;
			String isPlace = request.getParameter("place");
			if (name != null && !name.equalsIgnoreCase("null") && (name.length() > 0) )
			{
				memberList = (List<Member>) handler.findByName(name);
			} else if (isPlace != null && !isPlace.equalsIgnoreCase("null") && (isPlace.length() > 0) )
			{
				memberList = (List<Member>) handler.findByPlace(name);
			} else
			{
			//  display expired members if requested
			    String expired = request.getParameter("expired");
			    if (expired != null && expired.equalsIgnoreCase("yes"))
			    {
			    	isExpired = true;
			    	memberList = (List<Member>)handler.findExpiredMembers();
			    } else
			    {
					memberList = (List<Member>) handler.findAll(0, 30);	
			    }
			}

			if (!memberList.isEmpty()) {
				for (Iterator iterator = memberList.iterator(); iterator
						.hasNext();) {
					Member member = (Member) iterator.next();
					int memberId = member.getMemberId();
		%>
		<tr>
			<td style="width: 60px;"><a href="editMember.jsp?memberId=<%=memberId%>"><%=member.getName()%></a></td>
			<td><%=member.getEmail()%></td>
			<td><%=member.getGradSchool()%></td>
			
			<td><%=member.getEnglishScore()%></td>
			<td><%=member.getPlace()%></td>
			<td><%=member.getIsMember()%></td>
			<td><%=member.getExpiryDate()%></td>
			<td align="center"><a
					href="editMember.jsp?memberId=<%=memberId%>"><%=memberId%></a></td>
			<td align="center"><b><a
					href="deleteMember.jsp?memberId=<%=memberId%>"><img src="images/delete.png"/></a> </b></td>
			<td align="center"><b><a
					href="downgradeMember.jsp?memberId=<%=memberId%>">
					<img src="images/downgrade.png" width="30" height="30" /></a> </b></td>
		</tr>
		<%
				}
			} else
			{
				%>
				No member is found by <%= name %>
				<%
			
			}
		%>
	</table>
	<br>
	<hr>
	<center>
		<b><a href="newMember.jsp">Add a New Member</a></b>
	</center>
</body>
</html>
