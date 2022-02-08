package BeatSaverClasses;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"hash", "state", "createdAt", "sageScore", "diffs", "downloadURL", "coverURL", "previewURL"})
public class Version {

    @JsonProperty("hash")
    private String hash;
    @JsonProperty("state")
    private String state;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("sageScore")
    private Integer sageScore;
    @JsonProperty("diffs")
    private List<Diff> diffs = null;
    @JsonProperty("downloadURL")
    private String downloadURL;
    @JsonProperty("coverURL")
    private String coverURL;
    @JsonProperty("previewURL")
    private String previewURL;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("sageScore")
    public Integer getSageScore() {
        return sageScore;
    }

    @JsonProperty("sageScore")
    public void setSageScore(Integer sageScore) {
        this.sageScore = sageScore;
    }

    @JsonProperty("diffs")
    public List<Diff> getDiffs() {
        return diffs;
    }

    @JsonProperty("diffs")
    public void setDiffs(List<Diff> diffs) {
        this.diffs = diffs;
    }

    @JsonProperty("downloadURL")
    public String getDownloadURL() {
        return downloadURL;
    }

    @JsonProperty("downloadURL")
    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    @JsonProperty("coverURL")
    public String getCoverURL() {
        return coverURL;
    }

    @JsonProperty("coverURL")
    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    @JsonProperty("previewURL")
    public String getPreviewURL() {
        return previewURL;
    }

    @JsonProperty("previewURL")
    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
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
