import BeatSaverClasses.BeatSaverEntries;
import BeatSaverClasses.BeatSaverEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        String command = "curl -X GET \"https://api.beatsaver.com/maps/latest?automapper=false\" -H \"accept: application/json\"";
        Process process = Runtime.getRuntime()
                                 .exec(command);
        InputStream inputStream = process.getInputStream();
        String json = IOUtils.toString(inputStream, Charset.defaultCharset());
        System.out.println(json);

        ObjectMapper om = new ObjectMapper();
        BeatSaverEntries root = om.readValue(json, BeatSaverEntries.class);
        System.out.println(root.docs.get(0).name);
        System.out.println(root.docs.get(0).versions.get(0).downloadURL);

        String s = om.writer()
                     .writeValueAsString(root);

        System.out.println(s);
    }
}
