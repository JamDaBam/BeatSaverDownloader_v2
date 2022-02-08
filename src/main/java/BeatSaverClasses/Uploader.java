package BeatSaverClasses;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "hash", "avatar", "stats", "type"})
public class Uploader {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("avatar")
    public String getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
