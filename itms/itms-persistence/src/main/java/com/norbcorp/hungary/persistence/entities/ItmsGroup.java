package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itms_group database table.
 * 
 */
@Entity
@Table(name="itms_group")
@NamedQuery(name="ItmsGroup.findAll", query="SELECT i FROM ItmsGroup i")
public class ItmsGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-many association to ItmsUser
	@ManyToMany
	@JoinTable(
		name="itms_user_group"
		, joinColumns={
			@JoinColumn(name="group_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<ItmsUser> itmsUsers;

	//bi-directional many-to-many association to ItmsProject
	@ManyToMany(mappedBy="itmsGroups")
	private List<ItmsProject> itmsProjects;

	public ItmsGroup() {
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

	public List<ItmsUser> getItmsUsers() {
		return this.itmsUsers;
	}

	public void setItmsUsers(List<ItmsUser> itmsUsers) {
		this.itmsUsers = itmsUsers;
	}

	public List<ItmsProject> getItmsProjects() {
		return this.itmsProjects;
	}

	public void setItmsProjects(List<ItmsProject> itmsProjects) {
		this.itmsProjects = itmsProjects;
	}

}