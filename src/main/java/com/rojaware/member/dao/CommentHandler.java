package com.rojaware.member.dao;

import java.util.List;

import com.rojaware.member.model.Comment;
import com.rojaware.member.model.Member;

public interface CommentHandler {

	public abstract int add(Comment comment);
	public abstract int update(Comment comment);
	public abstract int delete(int commentId);
	public abstract int deleteByMember(int commentId);
	public abstract List<Comment> findCommentsByMember(int commentId);
	
}
