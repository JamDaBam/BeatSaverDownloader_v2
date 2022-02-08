package Modules;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RestUploaderDataProvider implements IUploaderDataProvider {

    @Override
    public String getById(String aId) {
        String COMMAND_ID = "curl -X GET \"https://api.beatsaver.com/users/id/%s\" -H \"accept: application/json\"";
        return exec(COMMAND_ID, aId);
    }

    @Override
    public String getByName(String aName) {
        String COMMAND_NAME = "curl -X GET \"https://api.beatsaver.com/users/name/%s\" -H \"accept: application/json\"";
        return exec(COMMAND_NAME, aName);
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
