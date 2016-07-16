package com.gestacweb.models.knowledge;

import com.gestacweb.models.problem.Problem;
import com.gestacweb.models.source.Source;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Knowledge.class)
public abstract class Knowledge_ {

	public static volatile SingularAttribute<Knowledge, Double> usageFrecuency;
	public static volatile SingularAttribute<Knowledge, String> keywords;
	public static volatile SingularAttribute<Knowledge, Double> veracity;
	public static volatile SingularAttribute<Knowledge, Double> rating;
	public static volatile SingularAttribute<Knowledge, String> description;
	public static volatile SingularAttribute<Knowledge, String> title;
	public static volatile SingularAttribute<Knowledge, Boolean> valid;
	public static volatile SingularAttribute<Knowledge, Problem> problem;
	public static volatile SingularAttribute<Knowledge, String> videoUrl;
	public static volatile SingularAttribute<Knowledge, Source> sourceWhoWrote;
	public static volatile SingularAttribute<Knowledge, Double> timeToSolved;
	public static volatile SingularAttribute<Knowledge, Date> createTime;
	public static volatile SingularAttribute<Knowledge, Source> sourceWithKnowledge;
	public static volatile SingularAttribute<Knowledge, Long> id;
	public static volatile SingularAttribute<Knowledge, String> briefDescription;
	public static volatile SingularAttribute<Knowledge, Source> sourceCanImprove;

}

