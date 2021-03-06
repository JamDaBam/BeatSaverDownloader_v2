package modules.dataprovider;

import java.util.concurrent.CompletableFuture;

public interface IUploaderDataProvider {
    CompletableFuture<String> getById(String aId);

    CompletableFuture<String> getByName(String aName);
}
