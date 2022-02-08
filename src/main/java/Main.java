import BeatSaverClasses.Collection;
import BeatSaverClasses.Uploader;
import Modules.DataProvider.ISongDataProvider;
import Modules.DataProvider.IUploaderDataProvider;
import Modules.DataProvider.RestSongDataProvider;
import Modules.DataProvider.RestUploaderDataProvider;
import Modules.Parser.IJsonParser;
import Modules.Parser.JackosnParser;

public class Main {
    public static void main(String[] args) {
        IJsonParser parser = new JackosnParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider();
        String latest = songDataProvider.getLatest();
        System.out.println(parser.parse(latest, Collection.class)
                                 .getDocs()
                                 .get(0));


        IUploaderDataProvider uploaderDataProvider = new RestUploaderDataProvider();
        String byId = uploaderDataProvider.getById("50472");
        Uploader uploader = parser.parse(byId, Uploader.class);
        System.out.println(uploader);


    }
}
