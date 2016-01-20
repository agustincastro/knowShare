package com.gestacweb.models.community;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "communities")
@NamedQueries({
        @NamedQuery(name = "findCommunityById", query = "from Community c where c.id = :id"),
        @NamedQuery(name = "findAllCommunities", query = "from Community c"),

})
public class Community implements Serializable{

    private long id;
    private String name;
    private String description;

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

    public void setDescription(String description) {
        this.description = description;
    }
}
