package com.gestacweb.models.knowledge;

import com.gestacweb.models.problem.Problem;
import com.gestacweb.models.source.Source;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "knowledges")
@NamedQueries({
        @NamedQuery(name = "findKnowledgeById", query = "select k from Knowledge k where k.id = :id"),
        @NamedQuery(name = "findAllKnowledges", query = "select k from Knowledge k where k.valid = true"),
        @NamedQuery(name = "findAllKnowledgesOrderByRating", query = "from Knowledge k order by k.rating desc"),
        @NamedQuery(name = "findKnowledgesThatSolvedProblem", query = "from Knowledge k where k.problem != null"),
        @NamedQuery(name = "findKnowledgesToImprove", query = "select k from Problem p, Knowledge k " +
        "where k.problem.id = p.id and k.sourceCanImprove != null and k.sourceCanImprove.id = :sourceId")

})
public class Knowledge implements Serializable {

    private long id;
    private String title;
    private Source sourceWhoWrote;
    private Source sourceWithKnowledge;
    private Problem problem;
    private String briefDescription;
    private String description;
    private double timeToSolved;
    private double usageFrecuency;
    private double veracity;
    private Date createTime;
    private String keywords;
    private String videoUrl;
    private Source sourceCanImprove;
    private double rating;
    private boolean valid;

    public Knowledge() {
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

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_who_wrote_id", nullable = false)
    public Source getSourceWhoWrote() {
        return sourceWhoWrote;
    }

    public void setSourceWhoWrote(Source source) {
        this.sourceWhoWrote = source;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_with_knowledge_id", nullable = false)
    public Source getSourceWithKnowledge() {
        return sourceWithKnowledge;
    }

    public void setSourceWithKnowledge(Source sourceWithKnowledge) {
        this.sourceWithKnowledge = sourceWithKnowledge;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Column(name = "brief_description", nullable = false)
    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "time_to_solved", nullable = true)
    public double getTimeToSolved() {
        return timeToSolved;
    }

    public void setTimeToSolved(double timeToSolved) {
        this.timeToSolved = timeToSolved;
    }

    @Column(name = "usage_frequency", nullable = true)
    public double getUsageFrecuency() {
        return usageFrecuency;
    }

    public void setUsageFrecuency(double usageFrecuency) {
        this.usageFrecuency = usageFrecuency;
    }

    @Column(name = "veracity", nullable = false)
    public double getVeracity() {
        return veracity;
    }

    public void setVeracity(double veracity) {
        this.veracity = veracity;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "created_time", unique = true, nullable = true, length = 10)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "keywords", nullable = false)
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Column(name = "video_url", nullable = true)
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_can_improve_id", nullable = false)
    public Source getSourceCanImprove() {
        return sourceCanImprove;
    }

    public void setSourceCanImprove(Source sourceCanImprove) {
        this.sourceCanImprove = sourceCanImprove;
    }

    @Column(name = "rating", nullable = false)
    public double getRating() {
        return rating;
    }

    @Type(type = "true_false")
    @Column(name = "valid", nullable = false)
    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("title", title);
        return object;
    }

    @Override
    public Knowledge clone(){

        return new Knowledge();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.id == ((Knowledge)obj).id)
            return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.sourceWhoWrote);
        hash = 67 * hash + Objects.hashCode(this.sourceWithKnowledge);
        hash = 67 * hash + Objects.hashCode(this.problem);
        hash = 67 * hash + Objects.hashCode(this.briefDescription);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.timeToSolved) ^ (Double.doubleToLongBits(this.timeToSolved) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.usageFrecuency) ^ (Double.doubleToLongBits(this.usageFrecuency) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.veracity) ^ (Double.doubleToLongBits(this.veracity) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.createTime);
        hash = 67 * hash + Objects.hashCode(this.keywords);
        hash = 67 * hash + Objects.hashCode(this.videoUrl);
        hash = 67 * hash + Objects.hashCode(this.sourceCanImprove);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.rating) ^ (Double.doubleToLongBits(this.rating) >>> 32));
        return hash;
    }

}
