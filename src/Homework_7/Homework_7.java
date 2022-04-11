package Homework_7;

import java.io.IOException;
import java.util.Scanner;

public class Homework_7 {
    public static void main(String[] args) throws IOException {
        String userInput;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter city name or 'exit' for leaving");
            userInput = input.nextLine();
            if (userInput.toLowerCase().equals("exit")) {
                break;
            }
            Forecast forecast = new Forecast();
            System.out.println(forecast.getForecast(forecast.getCityID(userInput), userInput));
        }
    }
}
