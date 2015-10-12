/**
 * 
 */
package com.rojaware.member.bo;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.rojaware.member.dao.CommentDao;
import com.rojaware.member.dao.MemberDao;
import com.rojaware.member.dao.MemberHanlder;
import com.rojaware.member.dao.CommentHandler;
import com.rojaware.member.model.Comment;
import com.rojaware.member.model.Member;

/**
 * @author scott
 *
 */
public class CustomerHandler implements MemberHanlder, CommentHandler {

	private static final int ROWS_BY_PAGE = 30;
	private static final int START_ROW = 0;
	private MemberHanlder memberDao = new MemberDao();
	private CommentDao commentDao = new CommentDao();
	/**
	 * 
	 */
	public CustomerHandler() {
		super();
	}
	public List<Member> findByName(String name)
	{
//		if (name == null || name == "" || name.equalsIgnoreCase("null"))
//			memberDao.findAll(START_ROW, ROWS_BY_PAGE);
		// return test object
		return memberDao.findByName(name);
		
	}
	
	public int add(Member member) {
		// TODO Auto-generated method stub
		return memberDao.add(member);
	}
	
	public int update(Member member) {
		// TODO Auto-generated method stub
		return memberDao.update(member);
	}
	
	public int delete(int memberId) {
		// TODO Auto-generated method stub
		return memberDao.delete(memberId);
	}
	
	public int deleteProfile(int memberId) {
		// TODO Auto-generated method stub
		return memberDao.deleteProfile(memberId);
	}
	
	public List<Member> findAll(int startingRow, int rowsByPage) {
		// TODO Auto-generated method stub
		return memberDao.findAll(startingRow, rowsByPage);
	}
	
	public Member findById(int id) {
		// TODO Auto-generated method stub
		return memberDao.findById(id);
	}
	
	public Member findByNaver(String naver) {
		// TODO Auto-generated method stub
		return memberDao.findByNaver(naver);
	}
	
	public Member findByEmail(String email) {
		// TODO Auto-generated method stub
		return memberDao.findByEmail(email);
	}
	
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.update(comment);
	}
	
	public int deleteByMember(int commentId) {
		// TODO Auto-generated method stub
		return commentDao.deleteByMember(commentId);
	}
	
	public int deleteComment(int commentId) {
		// TODO Auto-generated method stub
		return commentDao.delete(commentId);
	}
	
	public List<Comment> findCommentsByMember(int memberId) {
		// TODO Auto-generated method stub
		return commentDao.findCommentsByMember(memberId);
	}
	
	public int add(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.add(comment);
	}
	
	public List<Member> findExpiredMembers() {
		// TODO Auto-generated method stub
		return memberDao.findExpiredMembers();
	}
	
	public int downgradeMembership(int memberId) {
		// TODO Auto-generated method stub
		return memberDao.downgradeMembership(memberId);
	}
    public int sendExpiryMail() throws AddressException
    {
    	int result = 0;
    	EmailTest sender = new EmailTest();
    	try {
    		// search expired members
    		result = sender.sendMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
	
	public List<Member> findByPlace(String name) {
		return memberDao.findByPlace(name);
	}
}
