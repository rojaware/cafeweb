package com.rojaware.member.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the members database table.
 * 
 */
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	private int memberId;
    private String naver;
	private String birthYear;

	private String budget;

	private String career;

	private String children;

	private String college;

	private String content;

	private String counselor;

	private String created;

	private String email;

	private String englishScore;

	private String exitReason;

	private String expiryDate;

	private String fee;

	private String futurePlan;

	private String gradMajor;
	private String gradSchool;

	private String isMember;

	private String major;

	private String name;

	private String phone;

	private String place;

	private String sex;

	private String spouseName;

	private String visaType;

	public Member() {
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCareer() {
		return this.career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getChildren() {
		return this.children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCounselor() {
		return this.counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnglishScore() {
		return this.englishScore;
	}

	public void setEnglishScore(String englishScore) {
		this.englishScore = englishScore;
	}

	public String getExitReason() {
		return this.exitReason;
	}

	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getFee() {
		return this.fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getFuturePlan() {
		return this.futurePlan;
	}

	public void setFuturePlan(String futurePlan) {
		this.futurePlan = futurePlan;
	}

	public String getGradMajor() {
		return this.gradMajor;
	}

	public void setGradMajor(String gradMajor) {
		this.gradMajor = gradMajor;
	}

	public String getGradSchool() {
		return this.gradSchool;
	}

	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	public String getIsMember() {
		return this.isMember;
	}
	
	public boolean isIsMember() {
		if(isMember == null)
			return false;
		if ( isMember.equalsIgnoreCase("yes"))
		{
			return true;
		} else return false;
	
	}
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSex() {
		return this.sex;
	}
	public boolean isGirl() {
		if (sex.equalsIgnoreCase("female"))
			return true;
		else
			return false;
		
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getVisaType() {
		return this.visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public String getNaver() {
		return naver;
	}

	public void setNaver(String naver) {
		this.naver = naver;
	}

}