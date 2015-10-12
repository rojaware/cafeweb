<%@ page import="com.rojaware.member.bo.CustomerHandler"%>
<%@ page import="com.rojaware.member.model.*"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; euc-kr"
	pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*"%>

<html>
<head>
<title>Cafe Member: Add Comment</title>
</head>
<body bgcolor="#ffffee">

	<%
	    request.setCharacterEncoding("euc-kr");
	
		String memo = request.getParameter("memo");
		String memberId = request.getParameter("memberId");
		String commenterName = request.getParameter("commenterName");
		
		CustomerHandler handler = new CustomerHandler();
		Comment comment = new Comment();
		System.out.println(memo);
		comment.setComment(memo.trim());
		comment.setCommenterName(commenterName);
		comment.setMemberId(Integer.parseInt(memberId));
		int result = handler.add(comment);

		// New location to be redirected
		String site = new String("editComment.jsp?memberId="+memberId);
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	%>

</body>
</html>
