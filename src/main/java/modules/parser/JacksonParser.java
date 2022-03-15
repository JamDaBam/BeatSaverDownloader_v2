package modules.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;

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

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] parse(String[] aJsons, Class<T> aClass) {
        if (aJsons == null || aJsons.length == 0) {
            return null;
        }

        T[] res = (T[]) Array.newInstance(aClass, aJsons.length);

        for (int i = 0; i < aJsons.length; i++) {
            final String json = aJsons[i];
            res[i] = parse(json, aClass);
        }

        return res;
    }
}
