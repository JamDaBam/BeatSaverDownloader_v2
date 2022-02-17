package Modules.DataProvider;

public interface ISongDataProvider {
    String getById(String aId);

    String getLatest();

    String[] getLatest(int aPages);

    String getSongsFrom(String aUploaderId);
}
