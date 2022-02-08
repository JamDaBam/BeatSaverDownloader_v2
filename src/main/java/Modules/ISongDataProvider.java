package Modules;

import BeatSaverClasses.BeatsaverCollection;

public interface ISongDataProvider {
    String getLatest();
    String getSongsFrom(String aUploaderId);
}
