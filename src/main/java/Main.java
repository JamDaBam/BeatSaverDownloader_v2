import BeatSaverClasses.BeatsaverCollection;
import BeatSaverClasses.Uploader;
import Modules.ISongDataProvider;
import Modules.IUploaderDataProvider;
import Modules.RestSongDataProvider;
import Modules.RestUploaderDataProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {
        ISongDataProvider songDataProvider = new RestSongDataProvider();
        String latest = songDataProvider.getSongsFrom("50472");
        BeatsaverCollection beatsaverCollection = new ObjectMapper().readValue(latest, BeatsaverCollection.class);
//        System.out.println(beatsaverCollection.getDocs().get(0).getName());


        IUploaderDataProvider uploaderDataProvider = new RestUploaderDataProvider();
        String byId = uploaderDataProvider.getById("50472");
        Uploader uploader = new ObjectMapper().readValue(byId, Uploader.class);
        System.out.println(uploader.getName());


// ObjectMapper om = new ObjectMapper();
//BeatsaverCollection root = om.readValue(json, BeatsaverCollection.class);
//        System.out.println();
    }
}
