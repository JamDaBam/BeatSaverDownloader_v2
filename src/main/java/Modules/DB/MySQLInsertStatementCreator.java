package Modules.DB;

import BeatSaverClasses.*;

public class MySQLInsertStatementCreator implements IDataBaseInsertStatementCreator {
    @Override
    public String createInsert(Uploader aUploader) {
        Integer id = aUploader.getId();
        String name = aUploader.getName();
        String hash = aUploader.getHash();
        String avatar = aUploader.getAvatar();
        String type = aUploader.getType();

        return "INSERT IGNORE INTO Beatsaver.Uploader (uploaderId, name, hash, avatar, `type`) VALUES(" + id + ", '" + name + "', '" + hash + "', '" + avatar + "', '" + type + "');";
    }

    @Override
    public String createInsert(Doc aSong) {
        String id = aSong.getId();
        String name = aSong.getName()
                           .replace("'", "");
        String description = aSong.getDescription()
                                  .replace("'", "")
                                  .replace("\n", " ");
        String uploaded = aSong.getUploaded();
        Boolean automapper = aSong.getAutomapper();
        Boolean ranked = aSong.getRanked();
        Boolean qualified = aSong.getQualified();
        String createdAt = aSong.getCreatedAt();
        String updatedAt = aSong.getUpdatedAt();
        String lastPublishedAt = aSong.getLastPublishedAt();

        return "INSERT IGNORE INTO Beatsaver.Song (songId, name, description, uploaderId, metadataId, statsId, uploaded, automapper, ranked, qualified, createdAt, updatedAt, lastPublishedAt) VALUES('" + id + "', '" + name + "', '" + description + "', 'TODO', 'TODO', 'TODO', '" + uploaded + "', " + automapper + ", " + ranked + ", " + qualified + ", '" + createdAt + "', '" + updatedAt + "', '" + lastPublishedAt + "');";
    }

    @Override
    public String createInsert(Metadata aMetadata) {
        Double bpm = aMetadata.getBpm();
        Integer duration = aMetadata.getDuration();
        String songName = aMetadata.getSongName()
                                   .replace("'", "");
        String songSubName = aMetadata.getSongSubName()
                                      .replace("'", "");
        String songAuthorName = aMetadata.getSongAuthorName();
        String levelAuthorName = aMetadata.getLevelAuthorName();

        return "INSERT IGNORE INTO Beatsaver.Metadata (bpm, duration, songName, songSubName, songAuthorName, levelAuthorName) VALUES(" + bpm + ", " + duration + ", '" + songName + "', '" + songSubName + "', '" + songAuthorName + "', '" + levelAuthorName + "');";
    }

    @Override
    public String createInsert(Stats aStats) {
        Integer plays = aStats.getPlays();
        Integer downloads = aStats.getDownloads();
        Integer upvotes = aStats.getUpvotes();
        Integer downvotes = aStats.getDownvotes();
        Double score = aStats.getScore();

        return "INSERT IGNORE INTO Beatsaver.Stats (plays, downloads, upvotes, downvotes, score, songId) VALUES(" + plays + ", " + downloads + ", " + upvotes + ", " + downvotes + ", " + score + ", 'TODO');";
    }

    @Override
    public String createInsert(Version aVersion) {
        String hash = aVersion.getHash();
        String state = aVersion.getState();
        String createdAt = aVersion.getCreatedAt();
        Integer sageScore = aVersion.getSageScore();
        String downloadURL = aVersion.getDownloadURL();
        String coverURL = aVersion.getCoverURL();
        String previewURL = aVersion.getPreviewURL();

        return "INSERT IGNORE INTO Beatsaver.Version (hash, state, createdAt, sageScore, downloadURL, coverURL, previewURL) VALUES('" + hash + "', '" + state + "', '" + createdAt + "', '" + sageScore + "', '" + downloadURL + "', '" + coverURL + "', '" + previewURL + "');";
    }

    @Override
    public String createInsertSongVersion(long aSongId, long aVersionId) {
        return "INSERT IGNORE INTO Beatsaver.songversions (songId, versionId) VALUES(" + aSongId + ", " + aVersionId + ");";
    }

}
