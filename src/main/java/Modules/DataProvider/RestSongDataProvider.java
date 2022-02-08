package Modules.DataProvider;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RestSongDataProvider implements ISongDataProvider {
    private static final String COMMAND_ID = "curl -X GET \"https://api.beatsaver.com/maps/id/%s\" -H \"accept: application/json\"";
    private static final String COMMAND_LATEST = "curl -X GET \"https://api.beatsaver.com/maps/latest?automapper=false\" -H \"accept: application/json\"";
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
    public String getSongsFrom(String aUploaderId) {
        return exec(COMMAND_UPLOADER, aUploaderId);
    }


    private String exec(String aCommand, String aParam) {
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
}
