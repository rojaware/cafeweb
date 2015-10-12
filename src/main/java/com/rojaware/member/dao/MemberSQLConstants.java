package com.rojaware.member.dao;

public  interface  MemberSQLConstants {
	
	public static final String DELETE_MEMBER_SQL = 
			"DELETE FROM MEMBERS WHERE MEMBER_ID = ?";
	public static final String FIND_MEMBER_BY_ID_SQL = 
			"SELECT "
						+ "`birth_year`,"
						+   "`budget`,"
						+ "`career`,"
						+ "`children`,"
						+ "`college`,"
						+ "`content`,"
						+ "`counselor`,"
						+ "`created`,"
						+ "`email`,"
						+ "`english_score`,"
						+ "`exit_reason`,"
						+ "`expiry_date`,"
						+ "`fee`,"
						+ "`future_plan`,"
						+ "`grad_major`,"
						+ "`grad_school`,"
						+ "`isMember`,"					
						+ "`major`,"
						+ "`member_id`,"
						+ "`name`,"
						+ "`naver`,"
						+ "`phone`,"
						+ "`place`,"
						+ "`sex`,"
						+ "`spouse_name`,"
						+ "`visa_type` "
						+"FROM MEMBERS WHERE MEMBER_ID = ?";
	public static final String GET_LAST_MEMBER_ID_SQL = "SELECT MAX(member_id)  FROM members";
	public static final String GET_LAST_COMMENT_ID_SQL = "SELECT MAX(comment_id)  FROM comments";
	public static final String ADD_MEMBER_SQL = 
			"INSERT INTO `mapleedu`.`members`"
			+ "(`birth_year`,"
			+   "`budget`,"
			+ "`career`,"
			+ "`children`,"
			+ "`college`,"
			+ "`content`,"
			+ "`counselor`,"
			+ "`created`,"
			+ "`email`,"
			+ "`english_score`,"
			+ "`exit_reason`,"
			+ "`expiry_date`,"
			+ "`fee`,"
			+ "`future_plan`,"
			+ "`grad_major`,"
			+ "`grad_school`,"
			+ "`isMember`,"
			+ "`major`,"
			+ "`name`,"
			+ "`naver`,"
			+ "`phone`,"
			+ "`place`,"
			+ "`sex`,"
			+ "`spouse_name`,"
			+ "`visa_type`)"
+ "VALUES(?,?,?,?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_MEMBER_SQL = 
			"UPDATE MEMBERS SET birth_year = ?,"
						+ "budget = ?,"
						+ "career = ?,"
						+ "children = ?,"
						+ "college = ?,"
						+ "content = ?,"
						+ "counselor = ?,"
//						+ "created = ?,"
						+ "email = ?,"
						+ "english_score = ?,"
						+ "exit_reason = ?,"
						+ "expiry_date = ?,"
						+ "fee = ?,"
						+ "future_plan = ?,"
						+ "grad_major = ?,"
						+ "grad_school = ?,"
						+ "isMember = ?,"
						+ "major = ?,"
						+ "name = ?,"
						+ "naver = ?,"
						+ "phone = ?,"
						+ "place = ?,"
						+ "sex = ?,"
						+ "spouse_name = ?,"
						+ "visa_type = ?"
			+ "WHERE MEMBER_ID = ?";
	public static final String DOWNGRADE_MEMBER_SQL = 
			"UPDATE MEMBERS SET "
						+ " isMember= 'No',"
						+ "fee = 0 "
			+ "WHERE MEMBER_ID = ?";
	public static final String ADD_COMMENT_SQL = 
			"INSERT INTO COMMENTS "
				+ "(`comment`,"
				+ "`comment_date`,"
				+ "`commenter_name`,"
				+ "`member_id`)"
				+ "VALUE ( ?,now(),?,? ) ";

	public static final String UPDATE_COMMENT_SQL = 
			"UPDATE COMMENTS "
				+ " SET comment = ?,"
				+ " commenter_name = ?"
				+ " where COMMENT_ID = ? AND MEMBER_ID = ?";
	public static final String DELETE_COMMENT_SQL = "DELETE FROM COMMENTS WHERE COMMENT_ID = ?";
	public static final String DELETE_COMMENT_BY_MEMBER_SQL = "DELETE FROM COMMENTS WHERE MEMBER_ID = ?";
	public static final String FIND_COMMENTS_BY_MEMBER_SQL = 
			"SELECT COMMENT_ID, COMMENT, COMMENTER_NAME, MEMBER_ID, COMMENT_DATE" +
			" FROM COMMENTS WHERE MEMBER_ID = ? ORDER BY COMMENT_ID ASC";
	public static final String GET_ALL_MEMBERS_SQL =
			"SELECT SQL_CALC_FOUND_ROWS MEMBER_ID, NAME, EMAIL, " +
			"GRAD_SCHOOL, ENGLISH_SCORE, PLACE, ISMEMBER, EXPIRY_DATE FROM MEMBERS ORDER BY MEMBER_ID DESC LIMIT ?, ? "  // starting page
		 
//			+ "ORDER BY MEMBER_ID DESC"
			; // no of rows by page
	public static final String FIND_MEMBERS_BY_NAME_SQL =
			"SELECT SQL_CALC_FOUND_ROWS MEMBER_ID, NAME, EMAIL, " +
			"GRAD_SCHOOL, ENGLISH_SCORE, PLACE, ISMEMBER, EXPIRY_DATE FROM MEMBERS WHERE NAME LIKE ?"; 
	public static final String FIND_MEMBERS_BY_PLACE_SQL =
			"SELECT SQL_CALC_FOUND_ROWS MEMBER_ID, NAME, EMAIL, " +
			"GRAD_SCHOOL, ENGLISH_SCORE, PLACE, ISMEMBER, EXPIRY_DATE FROM MEMBERS WHERE PLACE LIKE ?"; 

	public static final String FIND_MEMBER_BY_NAVER_SQL =
			"SELECT SQL_CALC_FOUND_ROWS MEMBER_ID, NAME, EMAIL, " +
			"GRAD_SCHOOL, ENGLISH_SCORE, PLACE, ISMEMBER, EXPIRY_DATE FROM MEMBERS WHERE NAVER = ?"; 
	public static final String FIND_MEMBER_BY_EMAIL_SQL =
			"SELECT SQL_CALC_FOUND_ROWS MEMBER_ID, NAME, EMAIL, " +
			"GRAD_SCHOOL, ENGLISH_SCORE, PLACE, ISMEMBER, EXPIRY_DATE FROM MEMBERS WHERE EMAIL = ?";
	public static final String GET_MEMBER_SIZE_SQL =
			"SELECT COUNT(*) FROM MEMBERS";
	public static final String GET_COMMENT_SIZE_SQL =
			"SELECT COUNT(*) FROM COMMENTS WHERE MEMBER_ID = ?";
	public static final String FIND_EXPIRED_MEMBERS_SQL = 
			"select MEMBER_ID, NAME, EMAIL, " +
			"GRAD_SCHOOL, ENGLISH_SCORE, PLACE, ISMEMBER, EXPIRY_DATE from members where expiry_date < DATE(NOW())  and isMember like 'Yes'";
}
