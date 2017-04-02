package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the itms_comment database table.
 * 
 */
@Entity
@Table(name="itms_comment")
@NamedQuery(name="ItmsComment.findAll", query="SELECT i FROM ItmsComment i")
public class ItmsComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="comment_description")
	private String commentDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified")
	private Date lastModified;

	//bi-directional many-to-one association to ItmsIssue
	@ManyToOne
	@JoinColumn(name="issue_id")
	private ItmsIssue itmsIssue;

	//bi-directional many-to-one association to ItmsUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private ItmsUser itmsUser;

	public ItmsComment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentDescription() {
		return this.commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public ItmsIssue getItmsIssue() {
		return this.itmsIssue;
	}

	public void setItmsIssue(ItmsIssue itmsIssue) {
		this.itmsIssue = itmsIssue;
	}

	public ItmsUser getItmsUser() {
		return this.itmsUser;
	}

	public void setItmsUser(ItmsUser itmsUser) {
		this.itmsUser = itmsUser;
	}

}