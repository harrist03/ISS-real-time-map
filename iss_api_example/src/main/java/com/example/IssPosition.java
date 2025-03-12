package com.example;

public class IssPosition {
    private String longitude;
    private String latitude;
    private long timestamp;
    private String message;

    // non arg constructor
    public IssPosition() {}

    public IssPosition(String longitude, String latitude, long timestamp, String message) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
        this.message = message;
    }

    // Getters and Setters
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "IssPosition[ " +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ']';
    }
}
