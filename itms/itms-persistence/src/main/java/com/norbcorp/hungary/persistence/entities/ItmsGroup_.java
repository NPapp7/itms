package com.norbcorp.hungary.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.659+0200")
@StaticMetamodel(ItmsGroup.class)
public class ItmsGroup_ {
	public static volatile SingularAttribute<ItmsGroup, Integer> id;
	public static volatile SingularAttribute<ItmsGroup, String> description;
	public static volatile SingularAttribute<ItmsGroup, String> name;
	public static volatile ListAttribute<ItmsGroup, ItmsUser> itmsUsers;
	public static volatile ListAttribute<ItmsGroup, ItmsProject> itmsProjects;
}
