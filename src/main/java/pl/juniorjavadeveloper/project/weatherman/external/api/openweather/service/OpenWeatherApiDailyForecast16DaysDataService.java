package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.forecast.OpenWeatherApiDailyForecast16DaysDataResponse;
import pl.juniorjavadeveloper.project.weatherman.model.WeatherDataRequestModel;

import java.io.IOException;
import java.util.logging.Logger;

public class OpenWeatherApiDailyForecast16DaysDataService {
    // API Docs - https://openweathermap.org/forecast16 (Daily Forecast 16 Days)
    // https://www.latlong.net - Latitude and Longitude Finder
    // https://www.iso.org/obp/ui - Access the most up to date content in ISO standards

    private static final Logger LOGGER = Logger.getLogger(OpenWeatherApiDailyForecast16DaysDataService.class.getName());
    private static final String SERVER_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";

    public OpenWeatherApiDailyForecast16DaysDataResponse getWeatherForecast(WeatherDataRequestModel weatherDataRequest) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(SERVER_URL).newBuilder();
        urlBuilder.addQueryParameter("appid", "d2637e7f85faf82d4f6ddba63038faf2");

        if (weatherDataRequest.getCity() != null) {
            urlBuilder.addQueryParameter("q", weatherDataRequest.getCity() + "," + weatherDataRequest.getCountryCode());
        } else {
            urlBuilder.addQueryParameter("lat", String.valueOf(weatherDataRequest.getLatitude()));
            urlBuilder.addQueryParameter("lon", String.valueOf(weatherDataRequest.getLongitude()));
        }
        urlBuilder.addQueryParameter("cnt", String.valueOf(weatherDataRequest.getDays()));

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

            OpenWeatherApiDailyForecast16DaysDataResponse weatherDataResponse = deserializeResponse(bodyString);
            LOGGER.info("weatherDataResponse: " + weatherDataResponse);

            return weatherDataResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    OpenWeatherApiDailyForecast16DaysDataResponse deserializeResponse(String body) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            OpenWeatherApiDailyForecast16DaysDataResponse weatherDataResponse =
                    objectMapper.readValue(body, OpenWeatherApiDailyForecast16DaysDataResponse.class);
            LOGGER.info("weatherDataResponse: " + weatherDataResponse);

            return weatherDataResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
