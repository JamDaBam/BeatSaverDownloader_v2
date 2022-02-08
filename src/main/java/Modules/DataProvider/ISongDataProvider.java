package Modules.DataProvider;

public interface ISongDataProvider {
    String getById(String aId);

    String getLatest();

    String getSongsFrom(String aUploaderId);
}
