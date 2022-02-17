package BeatSaverClasses;

import Modules.DB.IDBDriver;
import Modules.DB.IDataBaseEntity;
import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "description", "uploader", "metadata", "stats", "uploaded", "automapper", "ranked", "qualified", "versions", "createdAt", "updatedAt", "lastPublishedAt", "tags"})
public class Doc implements IDataBaseEntity {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("uploader")
    private Uploader uploader;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("uploaded")
    private String uploaded;
    @JsonProperty("automapper")
    private Boolean automapper;
    @JsonProperty("ranked")
    private Boolean ranked;
    @JsonProperty("qualified")
    private Boolean qualified;
    @JsonProperty("versions")
    private List<Version> versions = null;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("lastPublishedAt")
    private String lastPublishedAt;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("uploader")
    public Uploader getUploader() {
        return uploader;
    }

    @JsonProperty("uploader")
    public void setUploader(Uploader uploader) {
        this.uploader = uploader;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;

        if (metadata != null) {
            metadata.setSongId(id);
        }
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;

        if (stats != null) {
            stats.setSongId(id);
        }
    }

    @JsonProperty("uploaded")
    public String getUploaded() {
        return uploaded;
    }

    @JsonProperty("uploaded")
    public void setUploaded(String uploaded) {
        this.uploaded = uploaded;
    }

    @JsonProperty("automapper")
    public Boolean getAutomapper() {
        return automapper;
    }

    @JsonProperty("automapper")
    public void setAutomapper(Boolean automapper) {
        this.automapper = automapper;
    }

    @JsonProperty("ranked")
    public Boolean getRanked() {
        return ranked;
    }

    @JsonProperty("ranked")
    public void setRanked(Boolean ranked) {
        this.ranked = ranked;
    }

    @JsonProperty("qualified")
    public Boolean getQualified() {
        return qualified;
    }

    @JsonProperty("qualified")
    public void setQualified(Boolean qualified) {
        this.qualified = qualified;
    }

    @JsonProperty("versions")
    public List<Version> getVersions() {
        return versions;
    }

    @JsonProperty("versions")
    public void setVersions(List<Version> versions) {
        this.versions = versions;

        if (versions != null) {
            for (Version version : versions) {
                version.setSongId(id);
            }
        }
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("lastPublishedAt")
    public String getLastPublishedAt() {
        return lastPublishedAt;
    }

    @JsonProperty("lastPublishedAt")
    public void setLastPublishedAt(String lastPublishedAt) {
        this.lastPublishedAt = lastPublishedAt;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
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

    @Override
    public void insert(IDBDriver aDBDriver) {
        Connection connection = aDBDriver.getConnection();
        uploader.insert(aDBDriver);

        String nameClean = name.replace("'", "''")
                               .replace("\\", "\\\\");
        String descriptionClean = description.replace("'", "''")
                                             .replace("\n", " ")
                                             .replace("\\", "\\\\");
        String preparedStatement = "INSERT IGNORE INTO Beatsaver.Song\n" + "(songId, name, description, uploaderId, uploaded, automapper, ranked, qualified, createdAt, updatedAt, lastPublishedAt)\n" + " VALUES('" + id + "', '" + nameClean + "', '" + descriptionClean + "', " + uploader.getId() + ", '" + uploaded + "', " + automapper + ", " + ranked + ", " + qualified + ", '" + createdAt + "', '" + updatedAt + "', '" + lastPublishedAt + "');\n";

        try {

            Statement statement = connection.createStatement();
            statement.execute(preparedStatement);
            statement.close();
        } catch (SQLException aE) {
            aE.printStackTrace();
            System.out.println(preparedStatement);
        }

        metadata.insert(aDBDriver);
        stats.insert(aDBDriver);

        if (versions != null) {
            for (Version version : versions) {
                version.insert(aDBDriver);
            }
        }

        System.out.println("processed " + id);
    }
}
