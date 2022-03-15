import beatsaverclasses.Collection;
import beatsaverclasses.Doc;
import modules.dataprovider.ISongDataProvider;
import modules.dataprovider.RestSongDataProvider;
import modules.db.IDBDriver;
import modules.db.MySQLDriver;
import modules.parser.IJsonParser;
import modules.parser.JacksonParser;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        IDBDriver driver = new MySQLDriver("root", "admin123", "localhost", "3306", "Beatsaver");
        IJsonParser parser = new JacksonParser();

        ISongDataProvider songDataProvider = new RestSongDataProvider(ZoneId.of("Europe/Berlin"));

        final CompletableFuture<String[]> jsonsFuture = songDataProvider.getLatest(2);

        final Collection[] parse = parser.parse(jsonsFuture.get(), Collection.class);
        final List<Doc> dbEntities = Arrays.stream(parse)
                                           .flatMap(aCollection -> aCollection.getDocs()
                                                                              .stream())
                                           .toList();

        for (int i = 0; i < dbEntities.size(); i++) {
            System.out.println("process... " + (i + 1) + " / " + dbEntities.size());
            dbEntities[i].insert(driver);
        }

        driver.close();
    }
}