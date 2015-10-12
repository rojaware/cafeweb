package com.rojaware.member.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;


import com.rojaware.member.dao.CommentDao;
import com.rojaware.member.dao.MemberDao;
import com.rojaware.member.model.Comment;
import com.rojaware.member.model.Member;

public class CommentDaoTester extends DaoTester {
	public Connection con;
	public PreparedStatement ptmt;
	public ResultSet rs;
	

	public CommentDaoTester(Connection con, PreparedStatement ptmt, ResultSet rs) {
		this.con = con;
		this.ptmt = ptmt;
		this.rs = rs;
	}

	public static void main(String[] args) {
		
		testAdd();
//		testUpdate();
//		testDelete() ;
//		deleteByMember() ;
		// display object detail
		
	}

	
	public static void testAdd() {
		System.out.println("display values in this object ");
	    CommentDao dao = new CommentDao();

	    // build test member
	    Comment c = makeTestData();
		int result = dao.add(c);
		
		System.out.println("New comment id is  " + result);
	}

	
	private static Comment makeTestData() {
		// TODO Auto-generated method stub
		Comment c = new Comment();
//		c.setComment("ì¤€ì˜¤ì”¨ê°€ í˜„ìž¬ ì˜�ì–´ì‹¤ë ¥ì�´ ì–´ëŠ�ì •ë�„ê°€ ë�˜ëŠ”ì§€, ë§ˆë‚˜í† ë°”ì�˜ RRCì—�ì„œ ESLê³¼ì •ì�„ ì–¼ë§ˆë‚˜ í•œ í›„ì—� ëŒ€í•™ìž…í•™ ì‹¤ë ¥ì�„ í™•ë³´í•  ìˆ˜ ìžˆì�„ì§€ëŠ” í˜„ìž¬ë¡œì„œëŠ” ëª¨ë¦…ë‹ˆë‹¤. í•˜ì—¬íŠ¼, ESLì—� ìž…í•™í•´ì„œ ë‚´ë…„ 9ì›” ë³¸ê³¼ìž…í•™ì�„ í•˜ê³ , ë‹¤ì‹œ ê³¼ë�½ì—†ì�´ 2ë…„ì�„ ê³µë¶€í•˜ë©´, 2013ë…„ ë´„ì—� ì¡¸ì—…. ê·¸ë¦¬ê³  ì˜�ì£¼ê¶Œì�„ ì‹ ì²­,,, ë§Œì�¼ ê³¼ë�½ì�„ í•˜ë©´ 2014ë…„ 5ì›”ì—� ì¡¸ì—…." +
//				"ì˜�ì£¼ê¶Œì‹ ì²­ì�€ í•  ìˆ˜ ìžˆìŠµë‹ˆë‹¤. ë‹¨, ë³‘ë¬´ì²­ì—� ê°€ì„œ ë‹¤ë¥¸ ë¬¸ì œê°€ ì—†ëŠ”ì§€ í™•ì�¸í•´ ë³´ì„¸ìš”. í•­ìƒ� ë‘�ë²ˆ ì �ê²€í•˜ëŠ” íƒœë�„ê°€ í•„ìš”í•©ë‹ˆë‹¤. " +
//				"í•œêµ­ìž…êµ­í• ë•Œ ì–´ë–»ê²Œ í•´ì•¼ êµ°ìž…ëŒ€ë¥¼ í”¼í•  ìˆ˜ ìžˆëŠ”ì§€, ë³‘ì—­ì�˜ë¬´ì‚¬í•­ì—� êµ¬ì†�ì�´ ë�˜ëŠ” ê²ƒì�€ ì–¸ì œê¹Œì§€ ì�¸ì§€.. ê°€ìž¥ í™•ì‹¤í•œ ëŒ€ë‹µì�€ ë³‘ë¬´ì²­ì—� ìžˆìŠµë‹ˆë‹¤. " +
//				"ê·¸ë¦¬ê³  ë³¸ì�¸ì�´ ë³‘ë¬´ì²­ ì‚¬ì�´íŠ¸ì—�ë�„ ë“¤ì–´ê°€ì„œ í™•ì�¸í•˜ê³ , ë˜�, ì§�ì ‘ ì°¾ì•„ê°€ì„œ ì‚¬ëžŒì�„ ë§Œë‚˜ì„œ ìƒ�ì�˜." +
//				"í•œíŽ¸, í•œêµ­ì—�ì„œ ì—­ì‚¬ê°€ ì˜¤ëž˜ë�œ ê°€ìž¥ í�° ì�´ì£¼ì—…ì²´ì—� ê°€ì„œ ë‹¤ì‹œ í•œë²ˆ í™•ì�¸..." +
//				"ê·¸ë¦¬ê³  ìœ í•™ì�„ ê°€ê¸°ë¡œ ê²°ì •í•˜ë©´ ë‹¤ì‹œ ë‚˜ì—�ê²Œ ì—°ë�½ì�„ ì£¼ì„¸ìš”. ìˆ˜ì†�ì�„ ë�„ì™€ì¤„ ìœ í•™ì›�ì�„ ì¶”ì²œí•´ì£¼ê² ìŠµë‹ˆë‹¤.");
		c.setComment("3333333333 ì¤€ì˜¤ì”¨ê°€ í˜„ìž¬ ì˜�ì–´ì‹¤ë ¥ì�´ ì–´ëŠ�ì •ë�„ê°€ ë�˜ëŠ”ì§€, ë§ˆë‚˜í† ë°”ì�˜ RRCì—�ì„œ ESLê³¼ì •ì�„ ì–¼ë§ˆë‚˜ í•œ í›„ì—� ëŒ€í•™ìž…í•™ ì‹¤ë ¥ì�„ í™•ë³´í•  ìˆ˜ ìžˆì�„ì§€ëŠ” í˜„ìž¬ë¡œì„œëŠ” ëª¨ë¦…ë‹ˆë‹¤. í•˜ì—¬íŠ¼, ESLì—� ìž…í•™í•´ì„œ ë‚´ë…„ 9ì›” ë³¸ê³¼ìž…í•™ì�„ í•˜ê³ , ë‹¤ì‹œ ê³¼ë�½ì—†ì�´ 2ë…„ì�„ ê³µë¶€í•˜ë©´, 2013ë…„ ë´„ì—� ì¡¸ì—…. ê·¸ë¦¬ê³  ì˜�ì£¼ê¶Œì�„ ì‹ ì²­,,, ë§Œì�¼ ê³¼ë�½ì�„ í•˜ë©´ 2014ë…„ 5ì›”ì—� ì¡¸ì—…." +
				"ì˜�ì£¼ê¶Œì‹ ì²­ì�€ í•  ìˆ˜ ìžˆìŠµë‹ˆë‹¤. ë‹¨, ë³‘ë¬´ì²­ì—� ê°€ì„œ ë‹¤ë¥¸ ë¬¸ì œê°€ ì—†ëŠ”ì§€ í™•ì�¸í•´ ë³´ì„¸ìš”. í•­ìƒ� ë‘�ë²ˆ ì �ê²€í•˜ëŠ” íƒœë�„ê°€ í•„ìš”í•©ë‹ˆë‹¤. ");
		c.setCommenterName("Rufina");
		c.setMemberId(6671);
		return c;
	}

	public static void testUpdate() {
		System.out.println("display values in this object ");
	    CommentDao dao = new CommentDao();

	    // build test member
	    Comment c = makeTestData();
	    // set commend id
	    c.setCommentId(8193);
		int result = dao.update(c);
		
		System.out.println("New comment id is  " + result);
	}

	
	public  static void testDelete() {
		System.out.println("display values in this object ");
	    CommentDao dao = new CommentDao();

	    int commentId = 8193;
		int result = dao.delete(commentId);
		
		System.out.println("commentId " + result + " has been deleted");
	}
	

	
	public  static void deleteByMember() {
		System.out.println("display values in this object ");
	    CommentDao dao = new CommentDao();

	    int memberId = 6669;
		int result = dao.deleteByMember(memberId);
		
		System.out.println("memberId comments " + result + " has been deleted");
	}
}