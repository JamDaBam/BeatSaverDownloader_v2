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
        IDBDriver dbriver = new MySQLDriver();

        IJsonParser parser = new JacksonParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider();
        String[] latest = songDataProvider.getLatest(10);


//        String[] latest = new String[]{songDataProvider.getLatest()};

        for (String json : latest) {
            Collection parse = parser.parse(json, Collection.class);


            List<Doc> docs = parse.getDocs();
            if (docs != null) {
                for (IDataBaseEntity song : docs) {
                    song.insert(dbriver);
                }
            }
        }


        dbriver.commit();
        dbriver.close();
    }
}
