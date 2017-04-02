package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the itms_issue database table.
 * 
 */
@Entity
@Table(name="itms_issue")
@NamedQuery(name="ItmsIssue.findAll", query="SELECT i FROM ItmsIssue i")
public class ItmsIssue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private String description;

	@Column(name="estimated_time")
	private String estimatedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date")
	private Date lastModifiedDate;

	@Column(name="remaining_time")
	private String remainingTime;

	private String title;

	@Column(name="work_time")
	private String workTime;

	//bi-directional many-to-one association to ItmsAttachment
	@OneToMany(mappedBy="itmsIssue")
	private List<ItmsAttachment> itmsAttachments;

	//bi-directional many-to-one association to ItmsComment
	@OneToMany(mappedBy="itmsIssue")
	private List<ItmsComment> itmsComments;

	//bi-directional many-to-one association to ItmsProject
	@ManyToOne
	@JoinColumn(name="project_id")
	private ItmsProject itmsProject;

	//bi-directional many-to-one association to ItmsStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private ItmsStatus itmsStatus;

	//bi-directional many-to-one association to ItmsType
	@ManyToOne
	@JoinColumn(name="type_id")
	private ItmsType itmsType;

	//bi-directional many-to-one association to ItmsUser
	@ManyToOne
	@JoinColumn(name="assigned_to_id")
	private ItmsUser itmsUser1;

	//bi-directional many-to-one association to ItmsUser
	@ManyToOne
	@JoinColumn(name="creator_id")
	private ItmsUser itmsUser2;

	public ItmsIssue() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEstimatedTime() {
		return this.estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getRemainingTime() {
		return this.remainingTime;
	}

	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public List<ItmsAttachment> getItmsAttachments() {
		return this.itmsAttachments;
	}

	public void setItmsAttachments(List<ItmsAttachment> itmsAttachments) {
		this.itmsAttachments = itmsAttachments;
	}

	public ItmsAttachment addItmsAttachment(ItmsAttachment itmsAttachment) {
		getItmsAttachments().add(itmsAttachment);
		itmsAttachment.setItmsIssue(this);

		return itmsAttachment;
	}

	public ItmsAttachment removeItmsAttachment(ItmsAttachment itmsAttachment) {
		getItmsAttachments().remove(itmsAttachment);
		itmsAttachment.setItmsIssue(null);

		return itmsAttachment;
	}

	public List<ItmsComment> getItmsComments() {
		return this.itmsComments;
	}

	public void setItmsComments(List<ItmsComment> itmsComments) {
		this.itmsComments = itmsComments;
	}

	public ItmsComment addItmsComment(ItmsComment itmsComment) {
		getItmsComments().add(itmsComment);
		itmsComment.setItmsIssue(this);

		return itmsComment;
	}

	public ItmsComment removeItmsComment(ItmsComment itmsComment) {
		getItmsComments().remove(itmsComment);
		itmsComment.setItmsIssue(null);

		return itmsComment;
	}

	public ItmsProject getItmsProject() {
		return this.itmsProject;
	}

	public void setItmsProject(ItmsProject itmsProject) {
		this.itmsProject = itmsProject;
	}

	public ItmsStatus getItmsStatus() {
		return this.itmsStatus;
	}

	public void setItmsStatus(ItmsStatus itmsStatus) {
		this.itmsStatus = itmsStatus;
	}

	public ItmsType getItmsType() {
		return this.itmsType;
	}

	public void setItmsType(ItmsType itmsType) {
		this.itmsType = itmsType;
	}

	public ItmsUser getItmsUser1() {
		return this.itmsUser1;
	}

	public void setItmsUser1(ItmsUser itmsUser1) {
		this.itmsUser1 = itmsUser1;
	}

	public ItmsUser getItmsUser2() {
		return this.itmsUser2;
	}

	public void setItmsUser2(ItmsUser itmsUser2) {
		this.itmsUser2 = itmsUser2;
	}

}