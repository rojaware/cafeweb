package com.rojaware.member.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;


import com.rojaware.member.dao.MemberDao;
import com.rojaware.member.dao.MemberHanlder;
import com.rojaware.member.model.Member;

public class MemberDaoTester extends DaoTester {
	public Connection con;
	public PreparedStatement ptmt;
	public ResultSet rs;
	

	public MemberDaoTester(Connection con, PreparedStatement ptmt, ResultSet rs) {
		this.con = con;
		this.ptmt = ptmt;
		this.rs = rs;
	}

	public static void main(String[] args) {
		
		testFindByName();
//		testAdd();
//		testFindById();
//		testFindByNaver();
//		testFindByEmail();
//		testFindAll();
//		testDelete();
//		testUpdate();
		// display object detail
		
	}

	/**
	 * @param memberDAO
	 */
	private static void testFindByName() {

	    MemberHanlder memberDAO = new MemberDao();
		System.out.println("display values in this object ");
		List<Member> members = memberDAO.findByName("황희연");
		System.out.println("Total " + members.size() + " records are found======>");
		Iterator<Member> iter = members.iterator();
		while ( iter.hasNext() )
		{
			Member member = (Member)iter.next();
			display(member, true);
		}
	}
	
	private static void testAdd() {
		System.out.println("display values in this object ");
	    MemberHanlder memberDAO = new MemberDao();

	    // build test member
	    Member m = makeTestMember();
		int result = memberDAO.add(m);
		System.out.println("New member id is  " + result);

	}

	/**
	 * @return
	 */
	private static Member makeTestMember() {
		Member m = new Member();
	    m.setBirthYear("1960");
	    m.setBudget("30000");
	    m.setCareer("ì˜�ì—…ì§� 5ë…„ ");
	    m.setChildren("No children");
	    m.setCollege("NAIT ");
	    m.setContent("-------------------------------------------"); // text
	    m.setCounselor("ê°•ìž�ì˜�");
	    m.setEmail("rojaware@yahoo.com");
	    m.setEnglishScore("900");
	    m.setExitReason("this is exist reason");
	    m.setExpiryDate("20130101"); // date
	    m.setFee("100");
	    m.setFuturePlan("my future plan is......"); // text
	    m.setGradMajor("ì „ì‚°ê³¼  ");
	    m.setGradSchool("ì²­ì£¼ëŒ€");
	    m.setIsMember("Yes"); // boolean
	    m.setMajor("computing");
	    m.setName("í™©í�¬ì—°");
	    m.setNaver("rojaware");
	    m.setPhone("905-502-1201");
	    m.setPlace("Toronto");
	    m.setSex("male"); // boolean
	    m.setSpouseName("í™©í�¬ì—°");
	    m.setVisaType("PR");
		return m;
	}

	
	public static void testUpdate() {

		MemberHanlder memberDAO = new MemberDao();
	
		Member member = makeTestMember();
		member.setMemberId(6669);
		int result = memberDAO.update(member);
		System.out.println("result is "+ result);
	}

	
	public static void testDelete() {
		MemberHanlder memberDAO = new MemberDao();
		int memberId = 6669;
		int result = memberDAO.delete(memberId);
		System.out.println("result is "+ result);
	}
	public static void testDeleteProfile() {
		MemberHanlder memberDAO = new MemberDao();
		int memberId = 6670;
		int result = memberDAO.deleteProfile(memberId);
		System.out.println("result is "+ result);
	}
	
	public static void testFindAll() {
	    MemberDao memberDAO = new MemberDao();
		System.out.println("display values in this object ");
		int startingRow = 0;
		int rowsByPage = 30;
		// check total size of record...
		int size = memberDAO.getTotalMemberSize();
		System.out.println("total member size is "+size);
		
		List<Member> members = memberDAO.findAll(startingRow, rowsByPage);
		System.out.println("Total " + members.size() + " records are found======>");
		Iterator<Member> iter = members.iterator();
		while ( iter.hasNext() )
		{
			Member member = (Member)iter.next();
			display(member, true);
		}
	}

	
	public static void testFindById() {
	    MemberHanlder memberDAO = new MemberDao();
		System.out.println("display values in this object ");
		Member m = memberDAO.findById(6670);
		
		display(m, true);
	
	}

	
	public static void testFindByNaver() {
	    MemberHanlder memberDAO = new MemberDao();
		System.out.println("display values in this object ");
		Member m = memberDAO.findByNaver("rojaware");
		
			display(m, true);
		
	}

	
	public static void testFindByEmail() {
	    MemberHanlder memberDAO = new MemberDao();
		System.out.println("display values in this object ");
		Member m = memberDAO.findByEmail("rojaware@yahoo.com");
		// should throw null pointer if not exist. add later....
		display(m, true);
	}



}