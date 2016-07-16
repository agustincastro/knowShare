package com.gestacweb.models.area;

import com.gestacweb.models.source.Source;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Area.class)
public abstract class Area_ {

	public static volatile SingularAttribute<Area, Boolean> valid;
	public static volatile SetAttribute<Area, Source> sources;
	public static volatile SingularAttribute<Area, String> name;
	public static volatile SingularAttribute<Area, String> description;
	public static volatile SingularAttribute<Area, Long> id;

}

