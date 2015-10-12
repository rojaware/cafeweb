package com.rojaware.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rojaware.member.bo.CustomerHandler;
import com.rojaware.member.model.Comment;
import com.rojaware.member.model.Member;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static String INSERT_OR_EDIT = "/editMember.jsp";
    private static String LIST_MEMBER = "/index.jsp";
    
	private CustomerHandler customerHandler;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        customerHandler = new CustomerHandler();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
        
        request.setCharacterEncoding("euc-kr");
        int memberId = Integer.parseInt(request.getParameter("memberId"));
        String memo = request.getParameter("comment");
        String commenterName = request.getParameter("commenterName");
        Comment comment = new Comment();
        comment.setComment(memo);
        comment.setCommenterName(commenterName);
        comment.setMemberId(memberId);
        
        customerHandler.add(comment);
//            dao.deleteUser(userId);
//            forward = LIST_USER;
//            request.setAttribute("users", dao.getAllUsers());    
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            int userId = Integer.parseInt(request.getParameter("userId"));
//            User user = dao.getUserById(userId);
//            request.setAttribute("user", user);
//        } else if (action.equalsIgnoreCase("listUser")){
//            forward = LIST_USER;
//            request.setAttribute("users", dao.getAllUsers());
//        } else {
//            forward = INSERT_OR_EDIT;
//        }
        forward = LIST_MEMBER;
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// build new member object from request
		req.setCharacterEncoding("euc-kr");
		Member member = new Member();
		member.setBirthYear(req.getParameter("birthYear"));
		member.setBudget(req.getParameter("budget"));
		member.setCareer(req.getParameter("career"));
		member.setChildren(req.getParameter("children"));
		member.setCollege(req.getParameter("college"));
		
		member.setContent(req.getParameter("content"));
		member.setCounselor(req.getParameter("counselor"));
		member.setEmail(req.getParameter("email"));
		member.setEnglishScore(req.getParameter("englishScore"));
		member.setExitReason(req.getParameter("exitReason"));
		
		member.setExpiryDate(req.getParameter("expiryDate"));
		member.setFee(req.getParameter("fee"));
		member.setFuturePlan(req.getParameter("futurePlan"));
		member.setGradMajor(req.getParameter("gradMajor"));
		member.setGradSchool(req.getParameter("gradSchool"));
		
		member.setIsMember(req.getParameter("isMember"));
		member.setMajor(req.getParameter("major"));
		String id = req.getParameter("memberId");

		int memberId = 0;
		boolean isUpdate = false;
		if (id != null  && memberId == 0)
		{
			memberId = Integer.parseInt(id);
			isUpdate = true;
			member.setMemberId(memberId);
		}
		String name = req.getParameter("name");
		member.setName(name);
		String naver = req.getParameter("naver");
		if (naver != null && !naver.equalsIgnoreCase("null"))
			member.setNaver(naver);
		member.setPhone(req.getParameter("phone"));
		
		member.setPlace(req.getParameter("place"));
		member.setSex(req.getParameter("sex"));
		member.setSpouseName(req.getParameter("spouseName"));
		member.setVisaType(req.getParameter("visaType"));
		

        if(!isUpdate)
        {
            customerHandler.add(member);
        }
        else
        {
            customerHandler.update(member);
        }
        // clean up previous search

        req.setCharacterEncoding("euc-kr");
//        req.setAttribute("memberId", "");
//        req.setAttribute("name", "");
        RequestDispatcher view = req.getRequestDispatcher(LIST_MEMBER);
        view.forward(req, res);
	}

}
