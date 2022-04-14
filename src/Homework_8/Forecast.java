package Homework_8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.*;
import java.util.*;

import java.io.IOException;

public class Forecast {

        private final String API_KEY = "HBAoYTHBeloWennir9bjrNSNYgoGaCqz";

        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        public String getCityID(String city){
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme("http")
                    .host("dataservice.accuweather.com")
                    .addPathSegment("locations")
                    .addPathSegment("v1")
                    .addPathSegment("cities")
                    .addPathSegment("search")
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("q", city)
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();

            try {
                String jsonResponse = client.newCall(request).execute().body().string();
                if (mapper.readTree(jsonResponse).get(0) == null) {
                    System.out.println("City " + city + " is not found.");
                    System.exit(1);
                }
                return mapper.readTree(jsonResponse)
                        .get(0)
                        .at("/Key").toString().replace("\"","");
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public ArrayList<Weather> getForecastDB(String cityID, String city){
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme("http")
                    .host("dataservice.accuweather.com")
                    .addPathSegment("forecasts")
                    .addPathSegment("v1")
                    .addPathSegment("daily")
                    .addPathSegment("5day")
                    .addPathSegment(cityID)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("metric", "true")
                    .addQueryParameter("language", "ru-ru")
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();


            ArrayList<Weather> forecastList = new ArrayList<>();
            try {
                String jsonResponse = client.newCall(request).execute().body().string();
                //System.out.println(jsonResponse);

                for (int i = 0; i < 5; i++) {
                    Weather forecast = new Weather();
                    forecast.setCity(city);
                    forecast.setLocalDate( mapper.readTree(jsonResponse)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Date").toString().substring(1,11));
                    forecast.setIconPhrase (mapper.readTree(jsonResponse)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Day/IconPhrase").toString().replace("\"",""));
                    forecast.setTemperatureMax (mapper.readTree(jsonResponse)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Temperature/Maximum/Value").toString());
                    forecast.setTemperatureMin( mapper.readTree(jsonResponse)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Temperature/Minimum/Value").toString());
                    forecastList.add(forecast);
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        return forecastList;
        }

    public String getForecast(String cityID, String city){
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityID)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", "true")
                .addQueryParameter("language", "ru-ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        String response = "";
        try {
            String jsonResponse = client.newCall(request).execute().body().string();
            //System.out.println(jsonResponse);
            for (int i = 0; i < 5; i++) {
                response += "В городе: " + city + " на дату ";
                response += mapper.readTree(jsonResponse)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Date").toString().substring(1,11);
                response += " ожидается " + mapper.readTree(jsonResponse)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Day/IconPhrase").toString().replace("\"","");
                response += ". Температура днём: " + mapper.readTree(jsonResponse)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Temperature/Maximum/Value").toString() + " C,";
                response += " ночью: " + mapper.readTree(jsonResponse)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Temperature/Minimum/Value").toString() + " C.\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    }


