package pl.juniorjavadeveloper.project.weatherman.model;

public class WeatherDataRequestModel {
    private String city;
    private String countryCode;
    private double latitude;
    private double longitude;

    public WeatherDataRequestModel(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public WeatherDataRequestModel(double latitude, double longitude) {
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
