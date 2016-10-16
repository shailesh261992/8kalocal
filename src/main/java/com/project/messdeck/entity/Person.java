package com.project.messdeck.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;

import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.MatchPattern;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@JsonView(Views.ID.class)
	public long id;

	@AssertValid
	@Embedded
	@JsonView(Views.Summary.class)
	private Name name;

	@MatchPattern(pattern = "^[789]\\d{9}$", message = "Invalid Mobile Number:Number should start with 7,8 or 9 & must be 10 digits")
	@Column(nullable = false)
	@JsonView(Views.Details.class)
	private String mobileNo;

	@AssertValid
	@Embedded
	@JsonView(Views.Details.class)
	private EmailID emailID;

	@JsonView(Views.Details.class)
	private Gender gender;

	public Person() {
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public EmailID getEmailID() {
		return emailID;
	}

	public void setEmailID(EmailID emailID) {
		this.emailID = emailID;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobileNo=" + mobileNo + ", emailID=" + emailID + ", gender=" + gender + "]";
	}

}
