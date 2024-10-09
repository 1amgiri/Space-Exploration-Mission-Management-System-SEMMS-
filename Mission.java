package models;

import java.sql.Date;

public class Mission {
    private int id;
    private String missionName;
    private String destination;
    private Date launchDate;
    private int spacecraftId;

    public Mission(int id, String missionName, String destination, Date launchDate, int spacecraftId) {
        this.id = id;
        this.missionName = missionName;
        this.destination = destination;
        this.launchDate = launchDate;
        this.spacecraftId = spacecraftId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getMissionName() { return missionName; }
    public String getDestination() { return destination; }
    public Date getLaunchDate() { return launchDate; }
    public int getSpacecraftId() { return spacecraftId; }
}
