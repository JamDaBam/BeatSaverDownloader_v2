package BeatSaverClasses;

import java.util.Date;
import java.util.List;

public class BeatSaverEntry {
    public String id;
    public String name;
    public String description;
    public Uploader uploader;
    public MetaData metadata;
    public Stats stats;
    public Date uploaded;
    public boolean automapper;
    public boolean ranked;
    public boolean qualified;
    public List<Version> versions;
}
