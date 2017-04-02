package com.norbcorp.hungary.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.695+0200")
@StaticMetamodel(ItmsType.class)
public class ItmsType_ {
	public static volatile SingularAttribute<ItmsType, Integer> id;
	public static volatile SingularAttribute<ItmsType, String> name;
	public static volatile ListAttribute<ItmsType, ItmsIssue> itmsIssues;
}
