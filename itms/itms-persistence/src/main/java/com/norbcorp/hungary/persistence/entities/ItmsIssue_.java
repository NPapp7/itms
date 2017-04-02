package com.norbcorp.hungary.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.665+0200")
@StaticMetamodel(ItmsIssue.class)
public class ItmsIssue_ {
	public static volatile SingularAttribute<ItmsIssue, Integer> id;
	public static volatile SingularAttribute<ItmsIssue, Date> createdDate;
	public static volatile SingularAttribute<ItmsIssue, String> description;
	public static volatile SingularAttribute<ItmsIssue, String> estimatedTime;
	public static volatile SingularAttribute<ItmsIssue, Date> lastModifiedDate;
	public static volatile SingularAttribute<ItmsIssue, String> remainingTime;
	public static volatile SingularAttribute<ItmsIssue, String> title;
	public static volatile SingularAttribute<ItmsIssue, String> workTime;
	public static volatile ListAttribute<ItmsIssue, ItmsAttachment> itmsAttachments;
	public static volatile ListAttribute<ItmsIssue, ItmsComment> itmsComments;
	public static volatile SingularAttribute<ItmsIssue, ItmsProject> itmsProject;
	public static volatile SingularAttribute<ItmsIssue, ItmsStatus> itmsStatus;
	public static volatile SingularAttribute<ItmsIssue, ItmsType> itmsType;
	public static volatile SingularAttribute<ItmsIssue, ItmsUser> itmsUser1;
	public static volatile SingularAttribute<ItmsIssue, ItmsUser> itmsUser2;
}
