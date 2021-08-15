import BeatSaverClasses.BeatSaverEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        String test = """
                {
                       "id": "1b4e5",
                       "name": "Hallman - I'm Going Like",
                       "description": "Mapper: TheCzar1994\\nSong Title: I'm Going Like\\nArtist: Hallman\\n\\nBPM: 126\\nNotes: 464\\nNPS: 2.47\\n\\nHuge thank you to monstor for testing the original for me!\\n\\nAlthough I made a couple maps previously, I'm going to count this as my first. I put a lot of care into it and am really proud of how it turned out!\\n\\nAlways open to additional feedback on Discord at TheCzar1994#9236",
                       "uploader": {
                           "id": 4285984,
                           "name": "TheCzar1994",
                           "hash": "60a1b026686b9f0006a4ae2c",
                           "avatar": "https://www.gravatar.com/avatar/60a1b026686b9f0006a4ae2c?d=retro"
                       },
                       "metadata": {
                           "bpm": 126.0,
                           "duration": 188,
                           "songName": "I'm Going Like",
                           "songSubName": "",
                           "songAuthorName": "Hallman",
                           "levelAuthorName": "TheCzar1994"
                       },
                       "stats": {
                           "plays": 0,
                           "downloads": 0,
                           "upvotes": 0,
                           "downvotes": 0,
                           "score": 0.5
                       },
                       "uploaded": "2021-08-15T20:59:50.413526Z",
                       "automapper": false,
                       "ranked": false,
                       "qualified": false,
                       "versions": [
                           {
                               "hash": "ae01a7970fc8fb164b93615088eb9bb5f11cbf9e",
                               "state": "Published",
                               "createdAt": "2021-08-15T20:56:37.544278Z",
                               "sageScore": 4,
                               "diffs": [
                                   {
                                       "njs": 14.0,
                                       "offset": 0.0,
                                       "notes": 464,
                                       "bombs": 0,
                                       "obstacles": 22,
                                       "nps": 2.8,
                                       "length": 348.0,
                                       "characteristic": "Standard",
                                       "difficulty": "Hard",
                                       "events": 660,
                                       "chroma": false,
                                       "me": false,
                                       "ne": false,
                                       "cinema": false,
                                       "seconds": 165.714,
                                       "paritySummary": {
                                           "errors": 0,
                                           "warns": 0,
                                           "resets": 0
                                       }
                                   }
                               ],
                               "downloadURL": "https://cdn.beatsaver.com/ae01a7970fc8fb164b93615088eb9bb5f11cbf9e.zip",
                               "coverURL": "https://cdn.beatsaver.com/ae01a7970fc8fb164b93615088eb9bb5f11cbf9e.jpg",
                               "previewURL": "https://cdn.beatsaver.com/ae01a7970fc8fb164b93615088eb9bb5f11cbf9e.mp3"
                           }
                       ]
                   }""".indent(5);

        ObjectMapper om = new ObjectMapper();
        BeatSaverEntry root = om.readValue(test, BeatSaverEntry.class);

        System.out.println(root.name);
        System.out.println(root.versions.get(0).downloadURL);

        String s = om.writer()
                     .writeValueAsString(root);

        System.out.println(s);

        String command = "curl -X GET \"https://api.beatsaver.com/maps/latest?automapper=false\" -H \"accept: application/json\"";
        Process process = Runtime.getRuntime().exec(command);
        InputStream inputStream = process.getInputStream();
        System.out.println(IOUtils.toString(inputStream, Charset.defaultCharset()));
    }
}
