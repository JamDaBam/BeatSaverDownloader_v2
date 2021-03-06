package beatsaverclasses;

import com.fasterxml.jackson.annotation.*;
import modules.db.IDBDriver;
import modules.db.IDataBaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "hash", "avatar", "type"})
public class Uploader implements IDataBaseEntity {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("avatar")
    private String avatar;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public void insert(IDBDriver aDBDriver) {
        Connection connection = aDBDriver.getConnection();

        String nameClean = name.replace("'", "''")
                               .replace("\\", "\\\\");
        String preparedStatement = """
                INSERT IGNORE INTO Beatsaver.Uploader
                (uploaderId, name, hash, avatar, `type`)
                """ + "VALUES(" + id + ", '" + nameClean + "', '" + hash + "', '" + avatar + "', '" + type + "');\n";

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
