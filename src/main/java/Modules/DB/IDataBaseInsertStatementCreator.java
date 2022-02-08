package Modules.DB;

import BeatSaverClasses.*;

public interface IDataBaseInsertStatementCreator {
    String createInsert(Uploader aUploader);

    String createInsert(Doc aSong);

    String createInsert(Metadata aMetadata);

    String createInsert(Stats aStats);

    String createInsert(Version aVersion);

    String createInsertSongVersion(long aSongId, long aVersionId);
}
