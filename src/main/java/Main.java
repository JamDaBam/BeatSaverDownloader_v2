import BeatSaverClasses.Collection;
import BeatSaverClasses.Doc;
import Modules.DB.IDBDriver;
import Modules.DB.IDataBaseEntity;
import Modules.DB.MySQLDriver;
import Modules.DataProvider.ISongDataProvider;
import Modules.DataProvider.RestSongDataProvider;
import Modules.Parser.IJsonParser;
import Modules.Parser.JacksonParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IJsonParser parser = new JacksonParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider();
        String latest = songDataProvider.getLatest();
        Collection parse = parser.parse(latest, Collection.class);

        IDBDriver dbriver = new MySQLDriver();


        List<Doc> docs = parse.getDocs();
        if (docs != null) {
            for (IDataBaseEntity song : docs) {
                song.insert(dbriver);
            }
        }

        dbriver.commit();
        dbriver.close();
    }
}
