package com.norbcorp.hungary.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.701+0200")
@StaticMetamodel(ItmsUser.class)
public class ItmsUser_ {
	public static volatile SingularAttribute<ItmsUser, Integer> id;
	public static volatile SingularAttribute<ItmsUser, String> name;
	public static volatile SingularAttribute<ItmsUser, String> password;
	public static volatile SingularAttribute<ItmsUser, Date> registeredDate;
	public static volatile SingularAttribute<ItmsUser, String> role;
	public static volatile SingularAttribute<ItmsUser, String> status;
	public static volatile ListAttribute<ItmsUser, ItmsComment> itmsComments;
	public static volatile ListAttribute<ItmsUser, ItmsGroup> itmsGroups;
	public static volatile ListAttribute<ItmsUser, ItmsIssue> itmsIssues1;
	public static volatile ListAttribute<ItmsUser, ItmsIssue> itmsIssues2;
}
