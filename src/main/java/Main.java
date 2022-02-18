import BeatSaverClasses.Collection;
import BeatSaverClasses.Doc;
import Modules.DB.IDBDriver;
import Modules.DB.IDataBaseEntity;
import Modules.DB.MySQLDriver;
import Modules.DataProvider.ISongDataProvider;
import Modules.DataProvider.RestSongDataProvider;
import Modules.Parser.IJsonParser;
import Modules.Parser.JacksonParser;
import Utils.DateUtil;

import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        IDBDriver driver = new MySQLDriver();
        IJsonParser parser = new JacksonParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider(ZoneId.of("Europe/Berlin"));

        CompletableFuture<Void> voidCompletableFuture = songDataProvider.getLatest(3, DateUtil.of(2018, 05, 8))
                                                                        .thenAcceptAsync(latest -> {

                                                                            int songFrom = 0;
                                                                            int songTo;

                                                                            for (String json : latest) {
                                                                                Collection parse = parser.parse(json, Collection.class);

                                                                                List<Doc> docs = parse.getDocs();
                                                                                songTo = songFrom + docs.size();

                                                                                System.out.println("process... " + songFrom + " to " + songTo);

                                                                                for (IDataBaseEntity song : docs) {
                                                                                    song.insert(driver);
                                                                                }

                                                                                songFrom = songTo;

                                                                                driver.commit();
                                                                            }

                                                                            driver.close();
                                                                        });

        voidCompletableFuture.join();
    }
}
