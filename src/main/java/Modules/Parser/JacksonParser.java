package Modules.Parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonParser implements IJsonParser {

    @Override
    public <T> T parse(String aJson, Class<T> aClass) {
        T res = null;

        ObjectMapper om = new ObjectMapper();
        try {
            res = om.readValue(aJson, aClass);
        } catch (JsonProcessingException aE) {
            aE.printStackTrace();
        }

        return res;
    }
}
