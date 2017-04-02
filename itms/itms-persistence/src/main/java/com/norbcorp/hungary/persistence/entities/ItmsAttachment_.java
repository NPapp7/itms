package com.norbcorp.hungary.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-01T22:29:01.643+0200")
@StaticMetamodel(ItmsAttachment.class)
public class ItmsAttachment_ {
	public static volatile SingularAttribute<ItmsAttachment, Integer> id;
	public static volatile SingularAttribute<ItmsAttachment, String> name;
	public static volatile SingularAttribute<ItmsAttachment, String> path;
	public static volatile SingularAttribute<ItmsAttachment, ItmsIssue> itmsIssue;
}
