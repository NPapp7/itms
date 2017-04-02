package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the itms_user database table.
 * 
 */
@Entity
@Table(name="itms_user")
@NamedQuery(name="ItmsUser.findAll", query="SELECT i FROM ItmsUser i")
public class ItmsUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="registered_date")
	private Date registeredDate;

	private String role;

	private String status;

	//bi-directional many-to-one association to ItmsComment
	@OneToMany(mappedBy="itmsUser")
	private List<ItmsComment> itmsComments;

	//bi-directional many-to-many association to ItmsGroup
	@ManyToMany(mappedBy="itmsUsers")
	private List<ItmsGroup> itmsGroups;

	//bi-directional many-to-one association to ItmsIssue
	@OneToMany(mappedBy="itmsUser1")
	private List<ItmsIssue> itmsIssues1;

	//bi-directional many-to-one association to ItmsIssue
	@OneToMany(mappedBy="itmsUser2")
	private List<ItmsIssue> itmsIssues2;

	public ItmsUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisteredDate() {
		return this.registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItmsComment> getItmsComments() {
		return this.itmsComments;
	}

	public void setItmsComments(List<ItmsComment> itmsComments) {
		this.itmsComments = itmsComments;
	}

	public ItmsComment addItmsComment(ItmsComment itmsComment) {
		getItmsComments().add(itmsComment);
		itmsComment.setItmsUser(this);

		return itmsComment;
	}

	public ItmsComment removeItmsComment(ItmsComment itmsComment) {
		getItmsComments().remove(itmsComment);
		itmsComment.setItmsUser(null);

		return itmsComment;
	}

	public List<ItmsGroup> getItmsGroups() {
		return this.itmsGroups;
	}

	public void setItmsGroups(List<ItmsGroup> itmsGroups) {
		this.itmsGroups = itmsGroups;
	}

	public List<ItmsIssue> getItmsIssues1() {
		return this.itmsIssues1;
	}

	public void setItmsIssues1(List<ItmsIssue> itmsIssues1) {
		this.itmsIssues1 = itmsIssues1;
	}

	public ItmsIssue addItmsIssues1(ItmsIssue itmsIssues1) {
		getItmsIssues1().add(itmsIssues1);
		itmsIssues1.setItmsUser1(this);

		return itmsIssues1;
	}

	public ItmsIssue removeItmsIssues1(ItmsIssue itmsIssues1) {
		getItmsIssues1().remove(itmsIssues1);
		itmsIssues1.setItmsUser1(null);

		return itmsIssues1;
	}

	public List<ItmsIssue> getItmsIssues2() {
		return this.itmsIssues2;
	}

	public void setItmsIssues2(List<ItmsIssue> itmsIssues2) {
		this.itmsIssues2 = itmsIssues2;
	}

	public ItmsIssue addItmsIssues2(ItmsIssue itmsIssues2) {
		getItmsIssues2().add(itmsIssues2);
		itmsIssues2.setItmsUser2(this);

		return itmsIssues2;
	}

	public ItmsIssue removeItmsIssues2(ItmsIssue itmsIssues2) {
		getItmsIssues2().remove(itmsIssues2);
		itmsIssues2.setItmsUser2(null);

		return itmsIssues2;
	}

}