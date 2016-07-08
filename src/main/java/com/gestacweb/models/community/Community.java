package com.gestacweb.models.community;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "communities")
@NamedQueries({
        @NamedQuery(name = "findCommunityById", query = "from Community c where c.id = :id"),
        @NamedQuery(name = "findAllCommunities", query = "from Community c where c.valid = true"),

})
public class Community implements Serializable{
    private long id;
    private String name;
    private String description;
    private boolean valid;

    public Community() {
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

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    @Type(type = "true_false")
    @Column(name = "valid", nullable = false)
    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.id == ((Community)obj).id)
            return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.description);
        return hash;
    }


}
