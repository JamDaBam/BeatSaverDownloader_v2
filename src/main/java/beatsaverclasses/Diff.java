package beatsaverclasses;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"njs", "offset", "notes", "bombs", "obstacles", "nps", "length", "characteristic", "difficulty", "events", "chroma", "me", "ne", "cinema", "seconds", "paritySummary"})
public class Diff {

    @JsonProperty("njs")
    private Double njs;
    @JsonProperty("offset")
    private Double offset;
    @JsonProperty("notes")
    private Integer notes;
    @JsonProperty("bombs")
    private Integer bombs;
    @JsonProperty("obstacles")
    private Integer obstacles;
    @JsonProperty("nps")
    private Double nps;
    @JsonProperty("length")
    private Double length;
    @JsonProperty("characteristic")
    private String characteristic;
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("events")
    private Integer events;
    @JsonProperty("chroma")
    private Boolean chroma;
    @JsonProperty("me")
    private Boolean me;
    @JsonProperty("ne")
    private Boolean ne;
    @JsonProperty("cinema")
    private Boolean cinema;
    @JsonProperty("seconds")
    private Double seconds;
    @JsonProperty("paritySummary")
    private ParitySummary paritySummary;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("njs")
    public Double getNjs() {
        return njs;
    }

    @JsonProperty("njs")
    public void setNjs(Double njs) {
        this.njs = njs;
    }

    @JsonProperty("offset")
    public Double getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Double offset) {
        this.offset = offset;
    }

    @JsonProperty("notes")
    public Integer getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(Integer notes) {
        this.notes = notes;
    }

    @JsonProperty("bombs")
    public Integer getBombs() {
        return bombs;
    }

    @JsonProperty("bombs")
    public void setBombs(Integer bombs) {
        this.bombs = bombs;
    }

    @JsonProperty("obstacles")
    public Integer getObstacles() {
        return obstacles;
    }

    @JsonProperty("obstacles")
    public void setObstacles(Integer obstacles) {
        this.obstacles = obstacles;
    }

    @JsonProperty("nps")
    public Double getNps() {
        return nps;
    }

    @JsonProperty("nps")
    public void setNps(Double nps) {
        this.nps = nps;
    }

    @JsonProperty("length")
    public Double getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(Double length) {
        this.length = length;
    }

    @JsonProperty("characteristic")
    public String getCharacteristic() {
        return characteristic;
    }

    @JsonProperty("characteristic")
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @JsonProperty("difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("events")
    public Integer getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(Integer events) {
        this.events = events;
    }

    @JsonProperty("chroma")
    public Boolean getChroma() {
        return chroma;
    }

    @JsonProperty("chroma")
    public void setChroma(Boolean chroma) {
        this.chroma = chroma;
    }

    @JsonProperty("me")
    public Boolean getMe() {
        return me;
    }

    @JsonProperty("me")
    public void setMe(Boolean me) {
        this.me = me;
    }

    @JsonProperty("ne")
    public Boolean getNe() {
        return ne;
    }

    @JsonProperty("ne")
    public void setNe(Boolean ne) {
        this.ne = ne;
    }

    @JsonProperty("cinema")
    public Boolean getCinema() {
        return cinema;
    }

    @JsonProperty("cinema")
    public void setCinema(Boolean cinema) {
        this.cinema = cinema;
    }

    @JsonProperty("seconds")
    public Double getSeconds() {
        return seconds;
    }

    @JsonProperty("seconds")
    public void setSeconds(Double seconds) {
        this.seconds = seconds;
    }

    @JsonProperty("paritySummary")
    public ParitySummary getParitySummary() {
        return paritySummary;
    }

    @JsonProperty("paritySummary")
    public void setParitySummary(ParitySummary paritySummary) {
        this.paritySummary = paritySummary;
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
