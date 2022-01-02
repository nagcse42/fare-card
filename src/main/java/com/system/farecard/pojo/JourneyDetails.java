package com.system.farecard.pojo;

public class JourneyDetails {
    private String entryZone;
    private String exitZone;
    private String channel;

    public JourneyDetails(){}

    public JourneyDetails(String entryZone, String exitZone, String channel) {
        this.entryZone = entryZone;
        this.exitZone = exitZone;
        this.channel = channel;
    }

    public String getEntryZone() {
        return entryZone;
    }

    public void setEntryZone(String entryZone) {
        this.entryZone = entryZone;
    }

    public String getExitZone() {
        return exitZone;
    }

    public void setExitZone(String exitZone) {
        this.exitZone = exitZone;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
