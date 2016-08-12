package com.knowshare.models.source;

import com.knowshare.models.area.Area;
import com.knowshare.models.community.Community;
import com.knowshare.models.knowledge.Knowledge;
import com.knowshare.models.problem.Problem;
import com.knowshare.models.user.User;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "source")
@DiscriminatorValue(User.SOURCE)
@NamedQueries({
        @NamedQuery(name = "findSourceById", query = "from Source s where s.id = :id"),
        @NamedQuery(name = "findAllSources", query = "from Source s where s.valid = true order by s.expertiseLevel desc"),
        @NamedQuery(name = "findAllSourcesOrderByRating", query = "from Source s where s.valid = true order by s.expertiseLevel desc ")
})
public class Source extends User{

    public Source(){
        valid = true;
    }

    private String description;

    private double expertiseLevel;

    private String sourceType;

    private Area area;

    private Community community;



    private Set<Knowledge> problemsToImprove;

    @Column(name = "expertise_level", nullable = true)
    public double getExpertiseLevel() {
        return expertiseLevel;
    }

    public void setExpertiseLevel(double expertLevel) {
        this.expertiseLevel = expertLevel;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "source_type", nullable = true)
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id", nullable = true)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable = true)
    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sourceCanImprove")
    public Set<Knowledge> getProblemsToImprove() {
        synchronized (this){
            return problemsToImprove;
        }
    }

    public void setProblemsToImprove(Set<Knowledge> problemsToImprove) {
        this.problemsToImprove = problemsToImprove;
    }

    //Depends only on id
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)getId();
        return result;
    }

    //Compare only id
    @Override
    public boolean equals(Object obj) {
        if (this.id == ((Source)obj).id)
            return true;
        else return false;
    }
}