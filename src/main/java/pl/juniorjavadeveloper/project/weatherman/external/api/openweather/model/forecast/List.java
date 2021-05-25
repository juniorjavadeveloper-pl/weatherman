
package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.forecast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "sunrise",
    "sunset",
    "temp",
    "feels_like",
    "pressure",
    "humidity",
    "weather",
    "speed",
    "deg",
    "gust",
    "clouds",
    "pop",
    "rain"
})
@Generated("jsonschema2pojo")
public class List {

    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sunrise")
    private Integer sunrise;
    @JsonProperty("sunset")
    private Integer sunset;
    @JsonProperty("temp")
    private Temp temp;
    @JsonProperty("feels_like")
    private FeelsLike feelsLike;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;
    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Integer deg;
    @JsonProperty("gust")
    private Double gust;
    @JsonProperty("clouds")
    private Integer clouds;
    @JsonProperty("pop")
    private Double pop;
    @JsonProperty("rain")
    private Double rain;

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("sunrise")
    public Integer getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public Integer getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("temp")
    public Temp getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("speed")
    public Double getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @JsonProperty("deg")
    public Integer getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    @JsonProperty("gust")
    public Double getGust() {
        return gust;
    }

    @JsonProperty("gust")
    public void setGust(Double gust) {
        this.gust = gust;
    }

    @JsonProperty("clouds")
    public Integer getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("pop")
    public Double getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Double pop) {
        this.pop = pop;
    }

    @JsonProperty("rain")
    public Double getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Double rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "List{" +
                "dt=" + dt +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weather=" + weather +
                ", speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                ", clouds=" + clouds +
                ", pop=" + pop +
                ", rain=" + rain +
                '}';
    }
}
