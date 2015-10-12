package com.rojaware.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rojaware.member.model.Member;
import com.rojaware.member.dao.MemberSQLConstants;

public class MemberDao extends BaseDao implements MemberSQLConstants, MemberHanlder{

	private CommentDao commentDao = null;
	public MemberDao() {
		super();
		commentDao = new CommentDao();
	}

	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#add(com.rojaware.member.model.Member)
	 */
	public int add(Member member) {

		int resultCode = 0;
		try {
			
			con = getConnection();
			ptmt = con.prepareStatement(ADD_MEMBER_SQL);
			
			ptmt.setString(1, member.getBirthYear());
			ptmt.setString(2, member.getBudget());

			String career = member.getCareer();
			ptmt.setString(3, removeEmptylines(career));
			ptmt.setString(4, member.getChildren());
			ptmt.setString(5, member.getCollege());
			String text = member.getContent();
			ptmt.setString(6, removeEmptylines(text));
			ptmt.setString(7, member.getCounselor());
//			Date date = new Date(0000-00-00);
//			String s = member.getCreated();
//			ptmt.setDate(8, date.valueOf(s));
			ptmt.setString(8, member.getEmail());
			String s = member.getEnglishScore();
			String englishScore = this.removeEmptylines(s);
			ptmt.setString(9, englishScore);
			ptmt.setString(10, member.getExitReason());
			ptmt.setString(11, member.getExpiryDate());//date
			ptmt.setString(12, member.getFee());
			ptmt.setString(13, member.getFuturePlan());
			ptmt.setString(14, member.getGradMajor());
			ptmt.setString(15, member.getGradSchool());
			ptmt.setString(16, member.getIsMember());// boolean
			ptmt.setString(17, member.getMajor());
			ptmt.setString(18, member.getName());	
			ptmt.setString(19, member.getNaver());
			ptmt.setString(20, member.getPhone());
			ptmt.setString(21, member.getPlace());
			ptmt.setString(22, member.getSex());// boolean
			ptmt.setString(23, member.getSpouseName());
			ptmt.setString(24, member.getVisaType());
		
			
			 ptmt.executeUpdate();
			 
			 // get member id
			 ptmt = con.prepareStatement(GET_LAST_MEMBER_ID_SQL);
			 rs = ptmt.executeQuery();
			 if (rs.next()) {
				 resultCode = rs.getInt(1);
			 }else
			 {
				 System.out.println("no member id, error");
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return resultCode;
	}

	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#update(com.rojaware.member.model.Member)
	 */
	public int update(Member member) {

		int result = 0;
		try {

			con = getConnection();
			ptmt = con.prepareStatement(UPDATE_MEMBER_SQL);

			ptmt.setString(1, member.getBirthYear());
			ptmt.setString(2, member.getBudget());
			String career = member.getCareer();
			ptmt.setString(3, removeEmptylines(career));
			ptmt.setString(4, member.getChildren());
			ptmt.setString(5, member.getCollege());

			String text = member.getContent();
			ptmt.setString(6, removeEmptylines(text));
			ptmt.setString(7, member.getCounselor());
//			ptmt.setString(8, member.getCreated());
			ptmt.setString(8, member.getEmail());
			String s = member.getEnglishScore();
			System.out.println("english score size is"+ s.length());
			ptmt.setString(9, member.getEnglishScore());
			ptmt.setString(10, member.getExitReason());
			ptmt.setString(11, member.getExpiryDate());
			ptmt.setString(12, member.getFee());
			ptmt.setString(13, member.getFuturePlan());
			ptmt.setString(14, member.getGradMajor());
			ptmt.setString(15, member.getGradSchool());			
			ptmt.setString(16, member.getIsMember());
			ptmt.setString(17, member.getMajor());
			ptmt.setString(18, member.getName());
			ptmt.setString(19, member.getNaver());		
			ptmt.setString(20, member.getPhone());
			ptmt.setString(21, member.getPlace());
			ptmt.setString(22, member.getSex());
			ptmt.setString(23, member.getSpouseName());			
			ptmt.setString(24, member.getVisaType());
			ptmt.setInt(25, member.getMemberId());
		    result = ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#delete(int)
	 */
	public int delete(int memberId)
	{
		// delete comment by the member first
		commentDao.deleteByMember(memberId);
		
		// delete profile
		return deleteProfile(memberId);
		// 
	}
	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#deleteProfile(int)
	 */
	public int deleteProfile(int memberId) {

		int result = 0;// success returns 1
		try {
			con = getConnection();
			ptmt = con.prepareStatement(DELETE_MEMBER_SQL);
			ptmt.setInt(1, memberId);
			result = ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#findAll(int, int)
	 */
	public List<Member> findAll(int startingRow, int rowsByPage) {
		List<Member> members = new ArrayList<Member>();
	
		try {
			
			con = getConnection();
			ptmt = con.prepareStatement(GET_ALL_MEMBERS_SQL);
			ptmt.setInt(1,  startingRow);
			ptmt.setInt(2, rowsByPage);
			members = getMemberResultSet(members);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return members;
	}

	/**
	 * @param members
	 * @throws SQLException
	 */
	private List<Member> getMemberResultSet(List<Member> members) throws SQLException {
		Member member;
		rs = ptmt.executeQuery();
		while (rs.next()) {
			member = new Member();
//name, email , MEMBER_ID, FEE, created 
			member.setMemberId(rs.getInt(1));
			member.setName(rs.getString(2));
			member.setEmail(rs.getString(3));
			member.setGradSchool(rs.getString(4));

			member.setEnglishScore(rs.getString(5));
			member.setPlace(rs.getString(6));
			member.setIsMember(rs.getString(7));
			member.setExpiryDate(rs.getString(8));

			members.add(member);
		}
		return members;
	}
	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#findById(int)
	 */
	public Member findById(int id) {
		List<Member> members = new ArrayList<Member>();
		
		try {
			
			con = getConnection();
			ptmt = con.prepareStatement(FIND_MEMBER_BY_ID_SQL);
			ptmt.setInt(1,  id);
			Member member;
			rs = ptmt.executeQuery();
			while (rs.next()) {
				member = new Member();
			
				member.setBirthYear((rs.getString(1)));
				member.setBudget((rs.getString(2)));
				member.setCareer((rs.getString(3)));
				member.setChildren((rs.getString(4)));
				member.setCollege(rs.getString(5));
				member.setContent(rs.getString(6));
				member.setCounselor(rs.getString(7));
				member.setCreated(rs.getString(8));
				member.setEmail(rs.getString(9));
				member.setEnglishScore(rs.getString(10));
				member.setExitReason(rs.getString(11));
				member.setExpiryDate(rs.getString(12));
				member.setFee(rs.getString(13));
				member.setFuturePlan(rs.getString(14));
				member.setGradMajor(rs.getString(15));
				member.setGradSchool(rs.getString(16));
				member.setIsMember(rs.getString(17));
				member.setMajor(rs.getString(18));
				member.setMemberId(rs.getInt(19));
				member.setName(rs.getString(20));
				member.setNaver(rs.getString(21));
				member.setPhone(rs.getString(22));
				member.setPlace(rs.getString(23));
				member.setSex(rs.getString(24));
				member.setSpouseName(rs.getString(25));
				member.setVisaType(rs.getString(26));
				
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (members.size() >0)
			return (Member)members.get(0);
		else
			return null;
		
	}
	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#findByNaver(java.lang.String)
	 */
	public Member findByNaver(String naver) {
		List<Member> members = new ArrayList<Member>();
		
		Member member = null;
		try {
			
			con = getConnection();
			ptmt = con.prepareStatement(FIND_MEMBER_BY_NAVER_SQL);
			ptmt.setString(1,  naver);
			members = getMemberResultSet(members);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (members.size() >0)
			return (Member)members.get(0);
		else
			return null;
		
	}
	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#findByEmail(java.lang.String)
	 */
	public Member findByEmail(String email) {
		List<Member> members = new ArrayList<Member>();
		
		try {
			
			con = getConnection();
			ptmt = con.prepareStatement(FIND_MEMBER_BY_EMAIL_SQL);
			ptmt.setString(1,  email);
			members = getMemberResultSet(members);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (members.size() >0)
			return (Member)members.get(0);
		else
			return null;
		
	}

	
	public int getTotalMemberSize() {
		
		int result = 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(this.GET_MEMBER_SIZE_SQL);
			rs = ptmt.executeQuery();
			if (rs.next())
			{
				result = rs.getInt(1);
			}else
			{
				System.out.println("Error: no record in member"); // throw error....later
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.rojaware.member.dao.MemberHanlder#findByName(java.lang.String)
	 */
	public List<Member> findByName(String name) {
		List<Member> members = new ArrayList<Member>();
		
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FIND_MEMBERS_BY_NAME_SQL);
			ptmt.setString(1, "%"+name+"%");
			members = getMemberResultSet(members);
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		return members;
	}
	public int downgradeMembership(int memberId)
	{
		int result = 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(this.DOWNGRADE_MEMBER_SQL);
			ptmt.setInt(1, memberId);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Member> findExpiredMembers() {
		List<Member> members = new ArrayList<Member>();
		
		try {
			con = getConnection();
			ptmt = con.prepareStatement(this.FIND_EXPIRED_MEMBERS_SQL);
			
			members = getMemberResultSet(members);
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		return members;
	}


	public List<Member> findByPlace(String name) {
List<Member> members = new ArrayList<Member>();
		
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FIND_MEMBERS_BY_PLACE_SQL);
			ptmt.setString(1, "%"+name+"%");
			members = getMemberResultSet(members);
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		return members;
	}
}
