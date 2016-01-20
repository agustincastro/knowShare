package com.gestacweb.models.source;

import com.gestacweb.models.DAO;
import com.gestacweb.models.area.Area;

import java.util.List;


public interface SourceDAO extends DAO<Source> {

    public List<Source> getMostRatedSources();

}
