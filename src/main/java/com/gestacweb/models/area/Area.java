package com.gestacweb.models.area;

import com.gestacweb.models.source.Source;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 11. Para registrar un Área se deberá ingresar: Nombre del área y una descripción de la misma.
 */
@Entity
@Table(name = "areas")
@NamedQueries({
        @NamedQuery(name = "findAreaById", query = "select a from Area a where a.id = :id"),
        @NamedQuery(name = "findAllAreas", query = "select a from Area a"),

})
public class Area implements Serializable{

    private long id;
    private String name;
    private String description;
    private Set<Source> sources;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "area")
    @OrderBy("expertiseLevel desc")
    public Set<Source> getSources() {
        return sources;
    }

    public void setSources(Set<Source> sources) {
        this.sources = sources;
    }

    //Depends only on id
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)id;
        return result;
    }

    //Compare only id
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        //if (getClass() != obj.getClass())
        //    return false;
        Area other = (Area) obj;
        if (id != other.getId())
            return false;
        return true;
    }


}
