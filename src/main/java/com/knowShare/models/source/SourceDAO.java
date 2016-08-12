package com.knowshare.models.source;

import com.knowshare.models.DAO;
import com.knowshare.models.area.Area;

import java.util.List;


public interface SourceDAO extends DAO<Source> {

    public List<Source> getMostRatedSources();

}
