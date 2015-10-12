/**
 * 
 */
package com.rojaware.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rojaware.member.model.Comment;

/**
 * @author MSA
 *
 */
public class CommentDao extends BaseDao implements MemberSQLConstants{
	public Connection con = null;
	public PreparedStatement ptmt = null;
	public ResultSet rs = null;

	
	public CommentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
 public int add(Comment comment)
	{
		int commentId = 0;
		try {

			con = getConnection();
			ptmt = con.prepareStatement(ADD_COMMENT_SQL);
			 
			String memo = removeEmptylines(comment.getComment());
			 ptmt.setString(1, memo);
			 ptmt.setString(2,  comment.getCommenterName());
			 ptmt.setInt(3,  comment.getMemberId());

			ptmt.executeUpdate();
			// get comment id
			ptmt = con.prepareStatement(GET_LAST_COMMENT_ID_SQL);
			rs = ptmt.executeQuery();
			if (rs.next())
				commentId = rs.getInt(1);
			else
				System.out.println("Error: no comment is added");

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
		return commentId;

	}

	public int update(Comment comment)
	{
		int resultCode = 0;
		try {

			con = getConnection();
			ptmt = con.prepareStatement(UPDATE_COMMENT_SQL);
			
			String memo = removeEmptylines(comment.getComment());
			 ptmt.setString(1, memo);
			 ptmt.setString(2,  comment.getCommenterName());
			 ptmt.setInt(3,  comment.getCommentId());
			 ptmt.setInt(4,  comment.getMemberId());

			resultCode = ptmt.executeUpdate();

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

	public int delete(int commentId)
	{
		int resultCode = 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(DELETE_COMMENT_SQL);
			ptmt.setInt(1, commentId);
			resultCode = ptmt.executeUpdate();

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
	
	public int deleteByMember(int memberId)
	{
		int resultCode = 0;
		try {
			con = getConnection();
			ptmt = con.prepareStatement(this.DELETE_COMMENT_BY_MEMBER_SQL);
			ptmt.setInt(1, memberId);
			resultCode = ptmt.executeUpdate();

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
	
	public List<Comment> findCommentsByMember(int commentId) {
		List<Comment> comments = new ArrayList<Comment>();
		
		try {
			con = getConnection();
			ptmt = con.prepareStatement(FIND_COMMENTS_BY_MEMBER_SQL);
			ptmt.setInt(1, commentId);
			comments = getCommentResultSet(comments);
			
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
		return comments;
	}
	private List<Comment> getCommentResultSet(List<Comment> comments) throws SQLException{
		
		Comment comment;
		rs = ptmt.executeQuery();
		while (rs.next()) {
			comment = new Comment();
			
			comment.setCommentId(rs.getInt(1));
			comment.setComment(rs.getString(2));
			comment.setCommenterName(rs.getString(3));
			comment.setMemberId(rs.getInt(4));
			comment.setCommentDate(rs.getTimestamp(5));

			comments.add(comment);
		}
		return comments;
	}
}
