package pl.juniorjavadeveloper.project.weatherman.model;

public class LocationModel {
    private String locationName;
    private double latitude;
    private double longitude;

    public LocationModel(String locationName) {
        this.locationName = locationName;
    }

    public LocationModel(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
