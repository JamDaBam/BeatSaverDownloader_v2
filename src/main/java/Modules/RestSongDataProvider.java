package Modules;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RestSongDataProvider implements ISongDataProvider {
    private static final String COMMAND_LATEST = "curl -X GET \"https://api.beatsaver.com/maps/latest?automapper=false\" -H \"accept: application/json\"";
    private static final String COMMAND_UPLOADER = "curl -X GET \"https://api.beatsaver.com/maps/uploader/%s/0\" -H \"accept: application/json\"";


    @Override
    public String getLatest() {
        String res = "";

        try {
            res = IOUtils.toString(Runtime.getRuntime()
                                          .exec(COMMAND_LATEST)
                                          .getInputStream(), Charset.defaultCharset());

        } catch (IOException aE) {
            aE.printStackTrace();
        }

        return res;
    }

    @Override
    public String getSongsFrom(String aUploaderId) {
        String res = "";

        try {
            res = IOUtils.toString(Runtime.getRuntime()
                                          .exec(String.format(COMMAND_UPLOADER, aUploaderId))
                                          .getInputStream(), Charset.defaultCharset());

        } catch (IOException aE) {
            aE.printStackTrace();
        }

        return res;
    }
}
