package com.gestacweb.models.problem;

import com.gestacweb.models.area.Area;
import com.gestacweb.models.knowledge.Knowledge;
import com.gestacweb.models.source.Source;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "problems")
@NamedQueries({
        @NamedQuery(name = "findProblemById", query = "from Problem p where p.id = :id"),
        @NamedQuery(name = "findAllProblems", query = "from Problem p"),
        /*@NamedQuery(name = "findUnsolvedProblems", query = "from Problem p " +
                "where p.id not in (select p1.id from Problem p1, Source s where p.area = s.area) " +
                "and p.id not in (select distinct k.problem.id from Knowledge k)"),
                */
        @NamedQuery(name = "findUnsolvedProblems", query = "from Problem p " +
                "where p.id not in (select distinct k.problem.id from Knowledge k)"),

        @NamedQuery(name = "findProblemsToImprove", query = "select p from Problem p, Knowledge k " +
                "where k.problem.id = p.id and k.sourceCanImprove != null and k.sourceCanImprove.id = :sourceId")

})
public class Problem implements Serializable{

    public Problem(){}

    private long id;
    private String title;
    private String description;
    private Area area;
    private List<Knowledge> knowledges;
    private Source bestSourceToSolveProblem;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id", nullable = false)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "problem")
    public List<Knowledge> getKnowledges() {
        return knowledges;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "best_source_id", nullable = true)
    public Source getBestSourceToSolveProblem() {
        return bestSourceToSolveProblem;
    }

    public void setBestSourceToSolveProblem(Source bestSourceToSolveProblem) {
        this.bestSourceToSolveProblem = bestSourceToSolveProblem;
    }

    public void setKnowledges(List<Knowledge> knowledges) {
        this.knowledges = knowledges;
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
        if (getClass() != obj.getClass())
            return false;
        Problem other = (Problem) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public JSONObject toJson() throws JSONException{
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("name", title);
        return object;
    }

}
