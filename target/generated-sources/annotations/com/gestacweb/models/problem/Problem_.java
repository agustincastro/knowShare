package com.gestacweb.models.problem;

import com.gestacweb.models.area.Area;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.source.Source;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Problem.class)
public abstract class Problem_ {

	public static volatile SingularAttribute<Problem, Area> area;
	public static volatile SingularAttribute<Problem, Boolean> valid;
	public static volatile SingularAttribute<Problem, Source> bestSourceToSolveProblem;
	public static volatile SingularAttribute<Problem, String> description;
	public static volatile SingularAttribute<Problem, Long> id;
	public static volatile SingularAttribute<Problem, String> title;
	public static volatile ListAttribute<Problem, Knowledge> knowledges;

}

