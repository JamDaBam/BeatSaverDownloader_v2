package Modules.DataProvider;

import java.util.concurrent.CompletableFuture;

public interface ISongDataProvider {
    CompletableFuture<String> getById(String aId);

    CompletableFuture<String> getLatest();

    CompletableFuture<String[]> getLatest(int aPages);

    CompletableFuture<String> getSongsFrom(String aUploaderId);
}
