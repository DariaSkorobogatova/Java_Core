package Homework_8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Homework8 {

    public static void main(String[] args) throws IOException, SQLException {
        String userInput1;
        String userInput2;
        Scanner input = new Scanner(System.in);
        Database database = new Database();
        while (true) {
            System.out.println("Enter city name or 'exit' for leaving");
            userInput1 = input.nextLine();
            if (userInput1.toLowerCase().equals("exit")) {
                break;
            }
            System.out.println("Enter 'R' if you want see all the records in Database");
            System.out.println("Enter 'F' if you only want to see forecast for the city");
            userInput2 = input.nextLine();
            if (userInput2.toLowerCase().equals("f")) {
                Forecast weatherForecast = new Forecast();
                database.saveWeatherData(weatherForecast.getForecastDB(weatherForecast.getCityID(userInput1), userInput1));
                System.out.println(weatherForecast.getForecast(weatherForecast.getCityID(userInput1), userInput1));
            }
            if (userInput2.toLowerCase().equals("r")) {
                Forecast weatherForecast = new Forecast();
                database.saveWeatherData(weatherForecast.getForecastDB(weatherForecast.getCityID(userInput1), userInput1));
                database.getAllForecasts();
            }
        }
    }
}