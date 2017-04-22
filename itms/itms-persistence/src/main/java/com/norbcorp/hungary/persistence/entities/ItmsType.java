package com.norbcorp.hungary.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the itms_type database table.
 * 
 */
@Entity
@Table(name="itms_type")
@NamedQuery(name="ItmsType.findAll", query="SELECT i FROM ItmsType i")
public class ItmsType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(unique=true)
	private String name;

	//bi-directional many-to-one association to ItmsIssue
	@OneToMany(mappedBy="itmsType")
	private List<ItmsIssue> itmsIssues;

	public ItmsType() {
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

	public List<ItmsIssue> getItmsIssues() {
		return this.itmsIssues;
	}

	public void setItmsIssues(List<ItmsIssue> itmsIssues) {
		this.itmsIssues = itmsIssues;
	}

	public ItmsIssue addItmsIssue(ItmsIssue itmsIssue) {
		getItmsIssues().add(itmsIssue);
		itmsIssue.setItmsType(this);

		return itmsIssue;
	}

	public ItmsIssue removeItmsIssue(ItmsIssue itmsIssue) {
		getItmsIssues().remove(itmsIssue);
		itmsIssue.setItmsType(null);

		return itmsIssue;
	}

}