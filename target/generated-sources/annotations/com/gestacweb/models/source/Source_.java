package com.gestacweb.models.source;

import com.gestacweb.models.area.Area;
import com.gestacweb.models.community.Community;
import com.gestacweb.models.knowledge.Knowledge;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Source.class)
public abstract class Source_ extends com.gestacweb.models.user.User_ {

	public static volatile SingularAttribute<Source, Area> area;
	public static volatile SetAttribute<Source, Knowledge> problemsToImprove;
	public static volatile SingularAttribute<Source, String> sourceType;
	public static volatile SingularAttribute<Source, Double> expertiseLevel;
	public static volatile SingularAttribute<Source, String> description;
	public static volatile SingularAttribute<Source, Community> community;

}

