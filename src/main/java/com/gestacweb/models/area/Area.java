package com.gestacweb.models.area;

import com.gestacweb.models.source.Source;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.hibernate.annotations.Type;

/**
 * 11. Para registrar un Área se deberá ingresar: Nombre del área y una descripción de la misma.
 */
@Entity
@Table(name = "areas")
@NamedQueries({
        @NamedQuery(name = "findAreaById", query = "select a from Area a where a.id = :id"),
        @NamedQuery(name = "findAllAreas", query = "select a from Area a where a.valid = true"),

})
public class Area implements Serializable{

    private long id;
    private String name;
    private String description;
    private Set<Source> sources;
    private boolean valid;

    public Area() {
      valid = true;
    }

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

    @Type(type = "true_false")
    @Column(name = "valid", nullable = false)
    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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

    @Override
    public boolean equals(Object obj) {
        if (this.id == ((Area)obj).id)
            return true;
        else return false;
    }


}
