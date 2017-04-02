package com.norbcorp.hungary.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.672+0200")
@StaticMetamodel(ItmsProject.class)
public class ItmsProject_ {
	public static volatile SingularAttribute<ItmsProject, Integer> id;
	public static volatile SingularAttribute<ItmsProject, String> description;
	public static volatile SingularAttribute<ItmsProject, String> name;
	public static volatile ListAttribute<ItmsProject, ItmsIssue> itmsIssues;
	public static volatile ListAttribute<ItmsProject, ItmsGroup> itmsGroups;
}
