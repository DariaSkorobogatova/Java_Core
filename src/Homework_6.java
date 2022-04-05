//С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени, пересекающийся со следующим занятием (например,
//        выборка погода на следующие 5 дней - подойдет Подобрать источник самостоятельно. Можно использовать api accuweather,
//        порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
//        Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения д/з).


import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.*;

public class Homework_6 {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("474212_PC")
                .addQueryParameter("apikey", "HBAoYTHBeloWennir9bjrNSNYgoGaCqz")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(request).execute().body().string();
        System.out.println(jsonResponse);

    }




    }

