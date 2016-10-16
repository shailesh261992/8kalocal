package com.project.messdeck.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.messdeck.Views;

import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotNull;

@Embeddable
public class EmailID {
	@Email(message = "Invalid EmailID")
	@NotNull(message = "EmailID  can not be null")
	@Column(unique = true, nullable = false)
	@JsonView(Views.Summary.class)
	private String emailId;

	public EmailID() {
		super();
	}

	public EmailID(String emailID) {
		this.emailId = emailID;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailID other = (EmailID) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailID [emailId=" + emailId + "]";
	}

}
