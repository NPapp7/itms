package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itms_attachments database table.
 * 
 */
@Entity
@Table(name="itms_attachments")
@NamedQuery(name="ItmsAttachment.findAll", query="SELECT i FROM ItmsAttachment i")
public class ItmsAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String path;

	//bi-directional many-to-one association to ItmsIssue
	@ManyToOne
	@JoinColumn(name="issue_id")
	private ItmsIssue itmsIssue;

	public ItmsAttachment() {
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ItmsIssue getItmsIssue() {
		return this.itmsIssue;
	}

	public void setItmsIssue(ItmsIssue itmsIssue) {
		this.itmsIssue = itmsIssue;
	}

}