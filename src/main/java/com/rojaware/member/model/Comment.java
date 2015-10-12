package com.rojaware.member.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the comments database table.
 * 
 */

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int commentId;

	private String comment;

	private Timestamp commentDate;

	private String commenterName;

	private int memberId;

	public Comment() {
	}

	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommenterName() {
		return this.commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}