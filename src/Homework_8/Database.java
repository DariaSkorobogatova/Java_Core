package Homework_8;

import org.sqlite.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Database {

private static final String DB_PATH = "jdbc:sqlite:WeatherForecast.db";
    private Connection connection;

    public Database() throws SQLException {
        DriverManager.deregisterDriver(new JDBC());
        this.connection = DriverManager.getConnection(DB_PATH);
    }

    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temp_max, temp_min) VALUES (?,?,?,?,?)";

    public void saveWeatherData(ArrayList<Weather> forecastList) {
        for (int i = 0; i < 5; i++) {
            try (
                 PreparedStatement saveWeather = this.connection.prepareStatement(insertWeatherQuery)) {
                saveWeather.setString(1, forecastList.get(i).getCity());
                saveWeather.setString(2, forecastList.get(i).getLocalDate());
                saveWeather.setString(3, forecastList.get(i).getIconPhrase());
                saveWeather.setString(4, forecastList.get(i).getTemperatureMax());
                saveWeather.setString(5, forecastList.get(i).getTemperatureMin());
                saveWeather.execute();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public void getAllForecasts(){
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT city, date_time, weather_text, temp_max, temp_min FROM Weather");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " - " +
                                resultSet.getString(2) + " - " +
                                resultSet.getString(3) + " - " +
                        resultSet.getString(4) + " - " +
                        resultSet.getString(5)
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
