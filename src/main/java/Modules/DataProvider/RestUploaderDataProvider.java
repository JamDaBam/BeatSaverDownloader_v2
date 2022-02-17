package Modules.DataProvider;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

public class RestUploaderDataProvider implements IUploaderDataProvider {
    private static final String COMMAND_ID = "curl -X GET \"https://api.beatsaver.com/users/id/%s\" -H \"accept: application/json\"";
    private static final String COMMAND_NAME = "curl -X GET \"https://api.beatsaver.com/users/name/%s\" -H \"accept: application/json\"";

    @Override
    public CompletableFuture<String> getById(String aId) {
        return CompletableFuture.supplyAsync(() -> exec(COMMAND_ID, aId));
    }

    @Override
    public CompletableFuture<String> getByName(String aName) {
        return CompletableFuture.supplyAsync(() -> exec(COMMAND_NAME, aName));
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
