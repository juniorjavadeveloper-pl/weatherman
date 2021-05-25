package pl.juniorjavadeveloper.project.weatherman.model;

public class LocationModel {
    private String city;
    private String countryCode;
    private double latitude;
    private double longitude;

    public LocationModel(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public LocationModel(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
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
                "city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
