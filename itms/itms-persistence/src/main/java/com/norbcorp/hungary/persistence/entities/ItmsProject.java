package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itms_project database table.
 * 
 */
@Entity
@Table(name="itms_project")
@NamedQuery(name="ItmsProject.findAll", query="SELECT i FROM ItmsProject i")
public class ItmsProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to ItmsIssue
	@OneToMany(mappedBy="itmsProject")
	private List<ItmsIssue> itmsIssues;

	//bi-directional many-to-many association to ItmsGroup
	@ManyToMany
	@JoinTable(
		name="itms_group_project"
		, joinColumns={
			@JoinColumn(name="project_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="group_id")
			}
		)
	private List<ItmsGroup> itmsGroups;

	public ItmsProject() {
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
		itmsIssue.setItmsProject(this);

		return itmsIssue;
	}

	public ItmsIssue removeItmsIssue(ItmsIssue itmsIssue) {
		getItmsIssues().remove(itmsIssue);
		itmsIssue.setItmsProject(null);

		return itmsIssue;
	}

	public List<ItmsGroup> getItmsGroups() {
		return this.itmsGroups;
	}

	public void setItmsGroups(List<ItmsGroup> itmsGroups) {
		this.itmsGroups = itmsGroups;
	}

}