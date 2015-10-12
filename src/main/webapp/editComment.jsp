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
<title>Cafe Member: Edit Comment</title>
</head>
<body bgcolor="#ffffee" ">

	<FORM METHOD=POST ACTION="index.jsp">
		Name: <INPUT TYPE=TEXT NAME=name SIZE=20>
		 <INPUT TYPE=SUBMIT value="find">
	</FORM>
	<FORM METHOD=GET ACTION="newMember.jsp">
		<INPUT type=SUBMIT value="new">
	</FORM>
	<%
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("memberId");
		int memberId = Integer.parseInt(id);
		%>
		<a href="editMember.jsp?memberId=<%=memberId%>"><%=id%></a>
		<br>
				
		<%
		CustomerHandler customerHandler = new CustomerHandler();
		
		Member member = (Member) customerHandler.findById(memberId);
		
		String name = member.getName();
		String memberType = "";
		if (member != null) {
			 memberId = member.getMemberId();
			 if (member.isIsMember() )
				 memberType = "Á¤È¸¿ø";
		}
	%>
	<h1>
	<center><%= memberType %> <a href="editMember.jsp?memberId=<%=memberId%>"> <%= name %></a></center></h1>
	<% 
		List<Comment> comments = customerHandler
				.findCommentsByMember(memberId);
		Iterator iter = comments.iterator();
	
		while (iter.hasNext()) {
			Comment comment = (Comment) iter.next();
			int commentId = comment.getCommentId();
	%>
	<FORM METHOD=POST ACTION="updateComment.jsp"><br>
	   <textarea NAME="memo"  cols=100><%=comment.getComment().trim() %></TEXTAREA>
		<input type=hidden name=commentId value="<%= commentId %>" >
		<input type=hidden name=memberId value="<%= memberId %>" >
		<br><input type="image" src="images/save.gif" name="image" width="30" height="30">
		 <a
			href="deleteComment.jsp?commentId=<%=commentId%>&&memberId=<%=memberId%>"><img
			src="images/delete.png"></a>(<%=comment.getCommentDate()%>)<br> 
	</FORM>
	<%
		}
		String commenterName = "Scott"; // TODO later get from user login
	%>
	<hr>
	<br>

	<INPUT type=SUBMIT value="save">
	</FORM>
	<form method=POST ACTION="addComment.jsp">
		 <textarea NAME="memo"  cols=150></TEXTAREA>
		<INPUT TYPE=HIDDEN name=memberId value="<%=id%>"> <INPUT
			TYPE=HIDDEN name=commenterName value="<%=commenterName%>"> <input
			type=SUBMIT value="add">
	</form>
</body>
</html>
