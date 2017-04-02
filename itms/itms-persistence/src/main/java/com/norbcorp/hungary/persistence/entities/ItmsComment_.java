package com.norbcorp.hungary.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.653+0200")
@StaticMetamodel(ItmsComment.class)
public class ItmsComment_ {
	public static volatile SingularAttribute<ItmsComment, Integer> id;
	public static volatile SingularAttribute<ItmsComment, String> commentDescription;
	public static volatile SingularAttribute<ItmsComment, Date> createdDate;
	public static volatile SingularAttribute<ItmsComment, Date> lastModified;
	public static volatile SingularAttribute<ItmsComment, ItmsIssue> itmsIssue;
	public static volatile SingularAttribute<ItmsComment, ItmsUser> itmsUser;
}
