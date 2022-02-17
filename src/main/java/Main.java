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
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        IDBDriver driver = new MySQLDriver();
        IJsonParser parser = new JacksonParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider();


        CompletableFuture<Void> voidCompletableFuture = songDataProvider.getLatest(2000)
                                                                        .thenAcceptAsync(latest -> {

                                                                            for (String json : latest) {
                                                                                Collection parse = parser.parse(json, Collection.class);

                                                                                List<Doc> docs = parse.getDocs();
                                                                                if (docs != null) {
                                                                                    for (IDataBaseEntity song : docs) {
                                                                                        song.insert(driver);
                                                                                    }
                                                                                }

                                                                                driver.commit();
                                                                            }

                                                                            driver.close();
                                                                        });

        voidCompletableFuture.join();
    }
}
