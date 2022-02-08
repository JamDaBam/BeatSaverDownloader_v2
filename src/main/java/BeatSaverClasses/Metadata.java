package BeatSaverClasses;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bpm", "duration", "songName", "songSubName", "songAuthorName", "levelAuthorName"})
public class Metadata {

    @JsonProperty("bpm")
    private Double bpm;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("songName")
    private String songName;
    @JsonProperty("songSubName")
    private String songSubName;
    @JsonProperty("songAuthorName")
    private String songAuthorName;
    @JsonProperty("levelAuthorName")
    private String levelAuthorName;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("bpm")
    public Double getBpm() {
        return bpm;
    }

    @JsonProperty("bpm")
    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("songName")
    public String getSongName() {
        return songName;
    }

    @JsonProperty("songName")
    public void setSongName(String songName) {
        this.songName = songName;
    }

    @JsonProperty("songSubName")
    public String getSongSubName() {
        return songSubName;
    }

    @JsonProperty("songSubName")
    public void setSongSubName(String songSubName) {
        this.songSubName = songSubName;
    }

    @JsonProperty("songAuthorName")
    public String getSongAuthorName() {
        return songAuthorName;
    }

    @JsonProperty("songAuthorName")
    public void setSongAuthorName(String songAuthorName) {
        this.songAuthorName = songAuthorName;
    }

    @JsonProperty("levelAuthorName")
    public String getLevelAuthorName() {
        return levelAuthorName;
    }

    @JsonProperty("levelAuthorName")
    public void setLevelAuthorName(String levelAuthorName) {
        this.levelAuthorName = levelAuthorName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
