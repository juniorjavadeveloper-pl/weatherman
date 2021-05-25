package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import java.io.IOException;
import java.util.logging.Logger;

public class OpenWeatherApiCurrentWeatherDataService {
    // API Docs - https://openweathermap.org/current (Current weather data)

    private static final Logger LOGGER = Logger.getLogger(OpenWeatherApiCurrentWeatherDataService.class.getName());
    private static final String SERVER_URL = "http://api.openweathermap.org/data/2.5/weather";

    public OpenWeatherApiCurrentWeatherDataResponse getWeather(LocationModel location) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(SERVER_URL).newBuilder();
        urlBuilder.addQueryParameter("appid", "4129a96d211a9341db7daff3b83901da");

        if (location.getLocationName() != null) {
            urlBuilder.addQueryParameter("q", location.getLocationName());
        } else {
            urlBuilder.addQueryParameter("lat", String.valueOf(location.getLatitude()));
            urlBuilder.addQueryParameter("lon", String.valueOf(location.getLongitude()));
        }

        HttpUrl httpUrl = urlBuilder.build();
        LOGGER.info("request URL: " + httpUrl);

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            ResponseBody responseBody = response.body();

            String bodyString = null;
            if (responseBody != null) {
                bodyString = responseBody.string();
            }
            LOGGER.info("bodyString: " + bodyString);

            OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = deserializeResponse(bodyString);
            LOGGER.info("weatherDataResponse: " + weatherDataResponse);

            return weatherDataResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    OpenWeatherApiCurrentWeatherDataResponse deserializeResponse(String body) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse =
                    objectMapper.readValue(body, OpenWeatherApiCurrentWeatherDataResponse.class);
            LOGGER.info("weatherDataResponse: " + weatherDataResponse);

            return weatherDataResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
