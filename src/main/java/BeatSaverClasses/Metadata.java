package BeatSaverClasses;

import Modules.DB.IDBDriver;
import Modules.DB.IDataBaseEntity;
import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bpm", "duration", "songName", "songSubName", "songAuthorName", "levelAuthorName"})
public class Metadata implements IDataBaseEntity {

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

    private String songId;

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

    public String getSongId() {
        return songId;
    }

    public void setSongId(String aSongId) {
        songId = aSongId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public void insert(IDBDriver aDBDriver) {
        Connection connection = aDBDriver.getConnection();

        String songNameClean = songName.replace("'", "''")
                                       .replace("\\", "\\\\");
        String songSubNameClean = songSubName.replace("'", "''")
                                             .replace("\\", "\\\\");
        String songAuthorNameClean = songAuthorName.replace("'", "''")
                                                   .replace("\\", "\\\\");
        String levelAuthorNameClean = levelAuthorName.replace("'", "''")
                                                     .replace("\\", "\\\\");
        String preparedStatement = "INSERT IGNORE INTO Beatsaver.Metadata\n" + "(songId, bpm, duration, songName, songSubName, songAuthorName, levelAuthorName)\n" + "VALUES('" + songId + "', " + bpm + ", " + duration + ", '" + songNameClean + "', '" + songSubNameClean + "', '" + songAuthorNameClean + "', '" + levelAuthorNameClean + "');\n";

        try {
            Statement statement = connection.createStatement();
            statement.execute(preparedStatement);
            statement.close();
        } catch (SQLException aE) {
            aE.printStackTrace();
            System.out.println(preparedStatement);
        }
    }
}
