package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itms_status database table.
 * 
 */
@Entity
@Table(name="itms_status")
@NamedQuery(name="ItmsStatus.findAll", query="SELECT i FROM ItmsStatus i")
public class ItmsStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to ItmsIssue
	@OneToMany(mappedBy="itmsStatus")
	private List<ItmsIssue> itmsIssues;

	public ItmsStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItmsIssue> getItmsIssues() {
		return this.itmsIssues;
	}

	public void setItmsIssues(List<ItmsIssue> itmsIssues) {
		this.itmsIssues = itmsIssues;
	}

	public ItmsIssue addItmsIssue(ItmsIssue itmsIssue) {
		getItmsIssues().add(itmsIssue);
		itmsIssue.setItmsStatus(this);

		return itmsIssue;
	}

	public ItmsIssue removeItmsIssue(ItmsIssue itmsIssue) {
		getItmsIssues().remove(itmsIssue);
		itmsIssue.setItmsStatus(null);

		return itmsIssue;
	}

}