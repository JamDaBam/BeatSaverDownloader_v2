import beatsaverclasses.Collection;
import beatsaverclasses.Doc;
import modules.dataprovider.ISongDataProvider;
import modules.dataprovider.RestSongDataProvider;
import modules.db.IDBDriver;
import modules.db.IDataBaseEntity;
import modules.db.MySQLDriver;
import modules.parser.IJsonParser;
import modules.parser.JacksonParser;

import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        IDBDriver driver = new MySQLDriver("root", "admin123", "localhost", "3306", "Beatsaver");
        IJsonParser parser = new JacksonParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider(ZoneId.of("Europe/Berlin"));

        CompletableFuture<Void> voidCompletableFuture = songDataProvider.getLatest(10)
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
