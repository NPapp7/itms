package com.norbcorp.hungary.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.689+0200")
@StaticMetamodel(ItmsStatus.class)
public class ItmsStatus_ {
	public static volatile SingularAttribute<ItmsStatus, Integer> id;
	public static volatile SingularAttribute<ItmsStatus, String> description;
	public static volatile SingularAttribute<ItmsStatus, String> name;
	public static volatile ListAttribute<ItmsStatus, ItmsIssue> itmsIssues;
}
