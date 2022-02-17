package Modules.DataProvider;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class RestSongDataProvider implements ISongDataProvider {
    private static final String COMMAND_ID = "curl -X GET \"https://api.beatsaver.com/maps/id/%s\" -H \"accept: application/json\"";
    private static final String COMMAND_LATEST = "curl -X GET \"https://api.beatsaver.com/maps/latest\" -H \"accept: application/json\"";
    private static final String COMMAND_LATEST_WITH_TIMESTAMP = "curl -X GET \"https://api.beatsaver.com/maps/latest?before=%s\" -H \"accept: application/json";
    private static final String COMMAND_UPLOADER = "curl -X GET \"https://api.beatsaver.com/maps/uploader/%s/0\" -H \"accept: application/json\"";

    @Override
    public String getById(String aId) {
        return exec(COMMAND_ID, aId);
    }

    @Override
    public String getLatest() {
        return exec(COMMAND_LATEST, "");
    }

    @Override
    public String[] getLatest(int aPages) {
        String[] res = new String[aPages];

        //Startdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH'%3A'MM'%3A'ss'%2B'00'%3A'00");
        String startDate = ZonedDateTime.now()
                                        .format(formatter);

        String currentDate = null;

        for (int i = 0; i < aPages; i++) {
            if (currentDate == null) {
                currentDate = startDate;
            }

            String json = exec(COMMAND_LATEST_WITH_TIMESTAMP, currentDate);
            res[i] = json;

            currentDate = getLastUploadedDate(json);
        }

        return res;
    }

    @Override
    public String getSongsFrom(String aUploaderId) {
        return exec(COMMAND_UPLOADER, aUploaderId);
    }


    private String exec(String aCommand, String... aParam) {
        if (aParam == null) {
            return "";
        }

        String res = "";

        try {

            res = IOUtils.toString(Runtime.getRuntime()
                                          .exec(String.format(aCommand, aParam))
                                          .getInputStream(), Charset.defaultCharset());
        } catch (IOException aE) {
            aE.printStackTrace();
        }

        return res;
    }

    private String getLastUploadedDate(String json) {
        String currentDate;
        String[] lines = json.split("\n");

        String lastUploadedTag = "";

        for (String line : lines) {
            if (line.contains("\"uploaded\":")) {
                lastUploadedTag = line;
            }
        }

        currentDate = lastUploadedTag.replace("\"uploaded\":", "")
                                     .replace("\"", "")
                                     .replace(",", "")
                                     .trim();
        return currentDate;
    }
}
