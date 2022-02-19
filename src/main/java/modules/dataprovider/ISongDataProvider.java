package modules.dataprovider;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public interface ISongDataProvider {
    CompletableFuture<String> getById(String aId);

    CompletableFuture<String> getLatest();

    CompletableFuture<String[]> getLatest(int aPages);

    CompletableFuture<String[]> getLatest(int aPages, Date aBeforeDate);

    CompletableFuture<String> getSongsFrom(String aUploaderId);
}
