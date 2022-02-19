package beatsaverclasses;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"errors", "warns", "resets"})
public class ParitySummary {

    @JsonProperty("errors")
    private Integer errors;
    @JsonProperty("warns")
    private Integer warns;
    @JsonProperty("resets")
    private Integer resets;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("errors")
    public Integer getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    @JsonProperty("warns")
    public Integer getWarns() {
        return warns;
    }

    @JsonProperty("warns")
    public void setWarns(Integer warns) {
        this.warns = warns;
    }

    @JsonProperty("resets")
    public Integer getResets() {
        return resets;
    }

    @JsonProperty("resets")
    public void setResets(Integer resets) {
        this.resets = resets;
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
