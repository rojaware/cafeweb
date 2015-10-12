<%@ page import="com.rojaware.member.bo.CustomerHandler"%>
<%@ page import="com.rojaware.member.model.Member"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; euc-kr"
	pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*"%>

<html>
<head>
<title>Cafe Member: Delete Comment</title>
</head>
<body bgcolor="#ffffee">



	<%
		String id = request.getParameter("commentId");
	    String memberId = request.getParameter("memberId");
		CustomerHandler handler = new CustomerHandler();
		int result = handler.deleteComment(Integer.parseInt(id));

		// New location to be redirected
		
		String site = new String("editComment.jsp?memberId="+memberId);
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	%>

</body>
</html>
