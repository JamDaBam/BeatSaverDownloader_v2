package BeatSaverClasses;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"plays", "downloads", "upvotes", "downvotes", "score"})
public class Stats {

    @JsonProperty("plays")
    private Integer plays;
    @JsonProperty("downloads")
    private Integer downloads;
    @JsonProperty("upvotes")
    private Integer upvotes;
    @JsonProperty("downvotes")
    private Integer downvotes;
    @JsonProperty("score")
    private Double score;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("plays")
    public Integer getPlays() {
        return plays;
    }

    @JsonProperty("plays")
    public void setPlays(Integer plays) {
        this.plays = plays;
    }

    @JsonProperty("downloads")
    public Integer getDownloads() {
        return downloads;
    }

    @JsonProperty("downloads")
    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @JsonProperty("upvotes")
    public Integer getUpvotes() {
        return upvotes;
    }

    @JsonProperty("upvotes")
    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    @JsonProperty("downvotes")
    public Integer getDownvotes() {
        return downvotes;
    }

    @JsonProperty("downvotes")
    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
