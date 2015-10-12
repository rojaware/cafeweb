package com.rojaware.member.dao;

import java.util.List;

import com.rojaware.member.model.Member;

public interface MemberHanlder {

	/**
	 * 
	 * @param member 
	 * @return int member id
	 */
	public abstract int add(Member member);

	public abstract int update(Member member);

	public abstract int delete(int memberId);

	public abstract int deleteProfile(int memberId);

	public abstract List<Member> findAll(int startingRow, int rowsByPage);

	public abstract Member findById(int id);

	public abstract Member findByNaver(String naver);

	public abstract Member findByEmail(String email);

	public abstract List<Member> findByName(String name);
	
	public abstract List<Member> findByPlace(String name);
	
	public abstract List<Member> findExpiredMembers();
	
	public int downgradeMembership(int memberId);

}